package net.maku.tenant.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.tenant.entity.SysUserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户角色关系
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface SysUserRoleDao extends BaseDao<SysUserRoleEntity> {
}