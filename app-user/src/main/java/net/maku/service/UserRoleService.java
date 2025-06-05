package net.maku.service;

import net.maku.entity.SysUserRoleEntity;
import net.maku.framework.mybatis.service.BaseService;

public interface UserRoleService extends BaseService<SysUserRoleEntity> {
    Boolean add(Long userId);
}
