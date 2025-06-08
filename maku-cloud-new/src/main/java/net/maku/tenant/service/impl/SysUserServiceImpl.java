package net.maku.tenant.service.impl;

import cn.hutool.crypto.SmUtil;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.AllArgsConstructor;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.tenant.dao.SysUserDao;
import net.maku.tenant.dto.TenantUserDTO;
import net.maku.tenant.dto.UpdatePasswordDTO;
import net.maku.tenant.entity.SysUserEntity;
import net.maku.tenant.service.SysUserRoleService;
import net.maku.tenant.service.SysUserService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
    private final SysUserRoleService sysUserRoleService;
    @Override
    public void updateUserPassword(UpdatePasswordDTO dto) {
        UpdateWrapper<SysUserEntity> wrapper = new UpdateWrapper<>();
        if (dto.getNewPassword() != null && !dto.getNewPassword().isEmpty()) {
            Long userId = sysUserRoleService.getUserId(dto.getTenantId());
            wrapper.eq("id", userId)
                            .set("password", SmUtil.sm3(dto.getNewPassword()));
            update(wrapper);
        }
    }

    @Override
    public void addTenantAccount(TenantUserDTO dto) {
        SysUserEntity user = new SysUserEntity();
        user.setTenantId(dto.getTenantId());
        user.setPassword(SmUtil.sm3(dto.getPassword()));
        user.setUsername(dto.getUsername());
        baseMapper.insert(user);
    }
}
