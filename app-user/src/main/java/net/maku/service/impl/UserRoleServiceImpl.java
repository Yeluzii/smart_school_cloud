package net.maku.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import net.maku.dao.SysRoleDao;
import net.maku.dao.SysUserRoleDao;
import net.maku.entity.SysRoleEntity;
import net.maku.entity.SysUserRoleEntity;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.service.UserRoleService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserRoleServiceImpl extends BaseServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements UserRoleService {
    private final SysRoleDao sysRoleDao;
    @Override
    public Boolean add(Long userId) {
        try {
            QueryWrapper<SysRoleEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("role_code", "ordinary_new_user");
            Long ordinaryNewUserRoleId = sysRoleDao.selectOne(queryWrapper).getId();
            SysUserRoleEntity  entity = new SysUserRoleEntity();
            entity.setUserId(userId);
            entity.setRoleId(ordinaryNewUserRoleId);
            baseMapper.insert(entity);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
