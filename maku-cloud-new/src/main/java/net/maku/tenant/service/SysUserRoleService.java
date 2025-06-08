package net.maku.tenant.service;

import net.maku.framework.mybatis.service.BaseService;
import net.maku.tenant.entity.SysUserRoleEntity;

public interface SysUserRoleService extends BaseService<SysUserRoleEntity> {
    // 查询租户负责人
    Long getUserId(Long tenantId);
}
