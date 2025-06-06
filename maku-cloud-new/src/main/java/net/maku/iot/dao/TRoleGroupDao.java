package net.maku.iot.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.iot.entity.TRoleGroupEntity;
import net.maku.iot.vo.DeviceVO;
import net.maku.iot.vo.RoleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * trg
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface TRoleGroupDao extends BaseDao<TRoleGroupEntity> {
    @Select("SELECT r.id,r.role_code,r.remark,r.name FROM sys_role r inner join t_role_group rg inner join sys_group g WHERE r.id = rg.role_id AND rg.group_id = g.id AND g.id = #{groupId}")
    List<RoleVO> selectRoleIdsByGroupId(@Param("groupId") Long groupId);
}
