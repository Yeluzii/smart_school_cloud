package net.maku.tenant.service;

import net.maku.framework.mybatis.service.BaseService;
import net.maku.tenant.entity.SysRoleEntity;
import net.maku.tenant.vo.RoleVO;

import java.util.List;

public interface RoleService extends BaseService<SysRoleEntity> {
    List<RoleVO> getRoleList(String name);
}
