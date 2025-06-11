package net.maku.alert.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.alert.entity.SysAlertEntity;
import net.maku.iot.vo.UserDeviceVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 告警配置表
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface SysAlertDao extends BaseDao<SysAlertEntity> {
    @Select("insert into sys_device_alert (device_id,alert_id) value (#{deviceId}, #{alertId})")
    void batchSave(Long deviceId, Long alertId);
    @Select(("SELECT DISTINCT d.id,d.name,d.running_status FROM iot_device d JOIN sys_device_alert da  WHERE d.id = da.device_id AND da.alert_id = #{alertId} and da.deleted = 0 and d.deleted = 0"))
    List<UserDeviceVO> selectDevicesByGroupId(@Param("alertId") Long alertId);
}
