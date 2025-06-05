package net.maku.tenant.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.tenant.entity.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色管理
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface SysRoleDao extends BaseDao<SysRoleEntity> {

}