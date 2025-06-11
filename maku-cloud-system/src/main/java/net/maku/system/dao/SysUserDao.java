package net.maku.system.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.system.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 系统用户
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface SysUserDao extends BaseDao<SysUserEntity> {
    @Select("SELECT DISTINCT u.password FROM sys_user u INNER JOIN sys_user_role ur ON u.id = ur.user_id WHERE (ur.role_id = 1 OR ur.role_id = 2) AND u.username = #{username} AND u.tenant_id = #{tenantId}")
    String getUser(Long tenantId, String username);

    List<SysUserEntity> getList(Map<String, Object> params);

    SysUserEntity getById(@Param("id") Long id);

    List<SysUserEntity> getRoleUserList(Map<String, Object> params);

    default SysUserEntity getByUsername(String username) {
        return this.selectOne(new QueryWrapper<SysUserEntity>().eq("username", username));
    }

    default SysUserEntity getByMobile(String mobile) {
        return this.selectOne(new QueryWrapper<SysUserEntity>().eq("mobile", mobile));
    }
}
