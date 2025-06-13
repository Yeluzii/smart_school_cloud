package net.maku.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.maku.convert.DeviceConvert;
import net.maku.dao.DeviceDao;
import net.maku.entity.Device;
import net.maku.feign.AlertLogService;
import net.maku.framework.common.cache.RedisCache;
import net.maku.framework.common.constant.Constant;
import net.maku.framework.common.exception.ServerException;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.query.DeviceQuery;
import net.maku.service.DeviceService;
import net.maku.vo.AlertLogVO;
import net.maku.vo.DeviceVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
public class DeviceServiceImpl extends BaseServiceImpl<DeviceDao, Device> implements DeviceService {
    private final MessageChannel mqttOutboundChannel;
    private final DeviceDao deviceDao;
    private final RedisCache redisCache;
    private final AlertLogService alertLogService;
    @Override
    public PageResult<DeviceVO> page(DeviceQuery query) {
        Map<String, Object> params = getParams(query);
        IPage<Device> page = getPage(query);
        params.put(Constant.PAGE, page);
        List<Device> list = baseMapper.getList(params);
        return new PageResult<>(DeviceConvert.INSTANCE.convertList(list), page.getTotal());
    }

    private Map<String, Object> getParams(DeviceQuery query) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", query.getName());
        params.put("type", query.getType());
        params.put("running_status", query.getRunningStatus());
        return params;
    }

    @Override
    public void sendCommand(Long deviceId, String command) {
        QueryWrapper<Device> query = new QueryWrapper<>();
        query.eq("id", deviceId);
        String uid = deviceDao.selectOne(query).getUid();
        query.eq("uid", uid);
        Device device = this.getOne(query);
        if (device == null) {
            throw new ServerException("设备不存在");
        }
        // 构建json命令
        Map<String, Object> map = new HashMap<>();
        map.put("uid", uid);
//        map.put("command", command);
//        String type = device.getType().toString();
//        switch (type){
//            case "fan":
//                map.put("fan", command);
//                break;
//            case "voice_led", "smart_led":
//                map.put("led", command);
//                break;
//            case "door":
//                map.put("door", command);
//                break;
//            default:
//                throw new ServerException("设备类型错误");
//        }
        Integer type = device.getType();
        switch (type){
            case 4:
                map.put("fan", command);
                break;
            case 1,2:
                map.put("led", command);
                break;
            case 3:
                map.put("door", command);
                break;
            default:
                throw new ServerException("设备类型错误");
        }
        String payload = JSON.toJSONString(map);
        Message<String> message = MessageBuilder.withPayload(payload)
                .setHeader("mqtt_topic", "device/control")
                .build();
        mqttOutboundChannel.send(message);
    }

    // 处理状态上报
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public void handleStatusMessage(Message<?> message) {
        String payload = message.getPayload().toString();
        try {
            JSONObject json = JSON.parseObject(payload);
            String uid = json.getString("uid");
            Boolean runningStatus = json.getBoolean("running_status");
            Boolean door = json.getBoolean("door");
            Boolean fan = json.getBoolean("fan");
            Float temperature = json.getFloat("temperature");
            Float humidity = json.getFloat("humidity");
            QueryWrapper<Device> query = new QueryWrapper<>();
            query.eq("uid", uid);
            Device device = deviceDao.selectOne(query);
            DeviceVO deviceData = new DeviceVO();
            if (device != null){
                deviceData.setId(device.getId());
                deviceData.setCode(device.getCode());
                deviceData.setName(device.getName());
                deviceData.setType(device.getType());
                deviceData.setUid(uid);
                deviceData.setTemperature(temperature);
                deviceData.setHumidity(humidity);
                deviceData.setDoor(door);
                deviceData.setFan(fan);
                deviceData.setRunningStatus(runningStatus);
            }
            // 更新redis状态
            redisCache.set(uid,deviceData);
            // 更新数据库状态
            UpdateWrapper<Device> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("uid", uid);
            if (runningStatus != null) {
                updateWrapper.set("running_status", runningStatus);
            }
            if (temperature != null){
                updateWrapper.set("temperature", temperature);
                // 新增温度告警
                if (temperature > 29){
                    assert device != null;
                    alertLogService.addAlertLog(device.getId(),json);
                    List<AlertLogVO> logs = alertLogService.getSysAlertLogByDeviceId(device.getId()).getData();
                }
            }
            if (humidity != null){
                updateWrapper.set("humidity", humidity);
            }
            if (door != null){
                updateWrapper.set("door", door);
            }
            if (fan != null){
                updateWrapper.set("fan", fan);
            }
            baseMapper.update(null, updateWrapper);
            log.info("设备状态更新：{} -> {},{},{},{},{}", uid, runningStatus,temperature,humidity,fan,door);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
