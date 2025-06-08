package net.maku.tenant.service;

import net.maku.framework.mybatis.service.BaseService;
import net.maku.tenant.dto.TenantUserDTO;
import net.maku.tenant.dto.UpdatePasswordDTO;
import net.maku.tenant.entity.SysUserEntity;

public interface SysUserService extends BaseService<SysUserEntity> {
    // 修改租户负责人密码
    void updateUserPassword(UpdatePasswordDTO dto);
    // 新增租户，加账号
    void addTenantAccount(TenantUserDTO dto);
}
