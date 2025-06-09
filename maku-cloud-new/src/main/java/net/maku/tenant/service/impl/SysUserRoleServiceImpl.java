package net.maku.tenant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.tenant.dao.SysUserRoleDao;
import net.maku.tenant.entity.SysUserRoleEntity;
import net.maku.tenant.service.SysUserRoleService;
import org.springframework.stereotype.Service;

@Service
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService {
    @Override
    public Long getUserId(Long tenantId) {
        QueryWrapper<SysUserRoleEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tenant_id", tenantId);
        queryWrapper.eq("role_id", 2);
        try{
            return baseMapper.selectOne(queryWrapper).getUserId();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addUserRole(Long userId) {
        SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
        sysUserRoleEntity.setUserId(userId);
        sysUserRoleEntity.setRoleId(2L);
        baseMapper.insert(sysUserRoleEntity);
    }
}
