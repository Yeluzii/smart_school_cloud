package net.maku.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.maku.convert.DeviceConvert;
import net.maku.dto.DeviceDTO;
import net.maku.entity.Device;
import net.maku.framework.common.cache.RedisCache;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.query.DeviceQuery;
import net.maku.service.DeviceService;
import net.maku.vo.DeviceVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/device")
@Tag(name = "设备模块")
@AllArgsConstructor
public class DeviceController {
    private final DeviceService deviceService;
    private final RedisCache redisCache;

    @PostMapping("/save")
    @Operation(summary = "新增设备")
    public Result<String> save(@Valid @RequestBody DeviceDTO deviceDto){
        deviceService.save(DeviceConvert.INSTANCE.convert(deviceDto));
        return Result.ok();
    }

    @GetMapping
    @Operation(summary = "分页获取设备列表")
    public Result<PageResult<DeviceVO>> page(@ParameterObject @Valid DeviceQuery query){
        return Result.ok(deviceService.page(query));
    }

    @GetMapping("/{deviceId}")
    @Operation(summary = "获取指定设备")
    public Result<DeviceVO> getDevice(@PathVariable String deviceId){
        QueryWrapper<Device> query = new QueryWrapper<>();
        query.eq("id",deviceId);
        Device device = deviceService.getOne(query);
        return Result.ok(DeviceConvert.INSTANCE.convert(device));
    }

    @GetMapping("realtime/{deviceId}")
    @Operation(summary = "获取redis设备状态")
    public Result<DeviceVO> getRealtimeDevice(@PathVariable String deviceId){
        QueryWrapper<Device> query = new QueryWrapper<>();
        query.eq("id",deviceId);
        String uid = deviceService.getOne(query).getUid();
        return Result.ok((DeviceVO) redisCache.get(uid));
    }

    @PostMapping("/control")
    @Operation(summary = "发送控制命令")
    public Result<String> sendCommand(@RequestParam Long deviceId,@RequestParam String command){
        deviceService.sendCommand(deviceId,command);
        return Result.ok("指令发送成功！");
    }

}
