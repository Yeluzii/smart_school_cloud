package net.maku.alert.dao;

import net.maku.alert.vo.AlertLogVO;
import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.alert.entity.SysAlertLogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 告警记录表
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface SysAlertLogDao extends BaseDao<SysAlertLogEntity> {
    @Select("SELECT DISTINCT al.id,i.name,i.uid,a.alert_name, a.alert_level, al.create_time,al.alert_info FROM sys_alert_log al JOIN sys_alert a JOIN iot_device i JOIN sys_device_alert da ON (i.id = da.device_id AND da.alert_id = a.id AND da.device_id = al.device_id) WHERE a.deleted = 0 AND i.deleted = 0 AND da.deleted = 0")
    public List<AlertLogVO> getAlertLogList();
}
