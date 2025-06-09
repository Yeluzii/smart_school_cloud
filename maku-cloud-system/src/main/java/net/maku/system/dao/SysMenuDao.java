package net.maku.system.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.system.entity.SysMenuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 菜单管理
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface SysMenuDao extends BaseDao<SysMenuEntity> {

	/**
	 * 查询所有菜单列表
	 *
	 * @param type 菜单类型
	 */
	List<SysMenuEntity> getMenuList(@Param("type") Integer type);

	/**
	 * 查询用户菜单列表
	 *
	 * @param userId 用户ID
	 * @param type 菜单类型
	 */
	List<SysMenuEntity> getUserMenuList(@Param("userId") Long userId, @Param("type") Integer type);

	@Select("select distinct m.* from sys_menu m inner join sys_role_menu rm inner join sys_tenant t inner join sys_package p inner join sys_role r where m.id = rm.menu_id and p.id = t.package_id and p.role_id = r.id and rm.role_id = r.id and t.id = #{tenantId} and m.deleted = 0 and m.type = #{type} order by sort asc")
	List<SysMenuEntity> getTenantMenuList(@Param("tenantId") Long tenantId, @Param("type") Integer type);
	/**
	 * 查询用户权限列表
	 * @param userId  用户ID
	 */
	List<String> getUserAuthorityList(@Param("userId") Long userId);
	/**
	 * 获取子菜单数量
	 *
	 * @param tenantId 租户ID
	 */
	@Select("select distinct m.authority from sys_menu m inner join sys_role_menu rm inner join sys_tenant t inner join sys_package p inner join sys_role r where m.id = rm.menu_id and p.id = t.package_id and p.role_id = r.id and rm.role_id = r.id and t.id = #{tenantId} and m.deleted = 0")
	List<String> getTenantAuthorityList(@Param("tenantId") Long tenantId);

	/**
	 * 查询所有权限列表
	 */
	List<String> getAuthorityList();

}
