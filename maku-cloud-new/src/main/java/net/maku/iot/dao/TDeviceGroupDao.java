package net.maku.iot.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.iot.entity.TDeviceGroupEntity;
import net.maku.iot.vo.DeviceVO;
import net.maku.iot.vo.UserDeviceVO;
import net.maku.iot.vo.UserGroupVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * tdg
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface TDeviceGroupDao extends BaseDao<TDeviceGroupEntity> {
    @Select("SELECT d.id,d.code,d.uid,d.name FROM iot_device d inner join t_device_group dg inner join sys_group g WHERE d.id = dg.device_id AND dg.group_id = g.id AND g.id = #{groupId} and g.deleted = 0 and dg.deleted = 0 and d.deleted = 0")
    List<DeviceVO> selectDeviceIdsByGroupId(@Param("groupId") Long groupId);
    @Select("SELECT DISTINCT g.id,g.name FROM sys_group g JOIN t_role_group t JOIN sys_user_role s ON s.role_id = t.role_id AND g.id = t.group_id WHERE s.user_id = #{userId} and g.deleted = 0 and t.deleted = 0 and s.deleted = 0")
    List<UserGroupVO> selectGroupIdsByUserId(@Param("userId") Long userId);
    @Select(("SELECT DISTINCT d.id,d.name,d.running_status FROM iot_device d JOIN t_device_group dg  WHERE d.id = dg.device_id AND dg.group_id = #{groupId} and dg.deleted = 0 and d.deleted = 0"))
    List<UserDeviceVO> selectDevicesByGroupId(@Param("groupId") Long groupId);
    @Select("SELECT type FROM iot_device WHERE id = #{deviceId} AND deleted = 0")
    Integer getDeviceType(@Param("deviceId") Long deviceId);
}
