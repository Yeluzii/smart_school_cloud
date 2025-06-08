package net.maku.tenant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.tenant.dao.SysRoleDao;
import net.maku.tenant.entity.SysRoleEntity;
import net.maku.tenant.service.RoleService;
import net.maku.tenant.vo.RoleVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl extends BaseServiceImpl<SysRoleDao, SysRoleEntity> implements RoleService {
    @Override
    public List<RoleVO> getRoleList(String name) {
        QueryWrapper<SysRoleEntity> queryWrapper = new QueryWrapper<>();
        if (name != null) {
            queryWrapper.like("name", name);
        }
        return baseMapper.selectList(queryWrapper).stream().map(vo -> {
            RoleVO roleVO = new RoleVO();
            roleVO.setId(vo.getId());
            roleVO.setName(vo.getName());
            return roleVO;
        }).toList();
    }

}
