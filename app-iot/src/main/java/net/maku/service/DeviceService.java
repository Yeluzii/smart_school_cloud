package net.maku.service;

import net.maku.entity.Device;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.query.DeviceQuery;
import net.maku.vo.DeviceVO;

public interface DeviceService extends BaseService<Device> {
    PageResult<DeviceVO> page(DeviceQuery query);
    void sendCommand(Long deviceId, String command);
}
