package net.maku.tenant.service.impl;

import cn.hutool.crypto.SmUtil;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.tenant.convert.SysTenantConvert;
import net.maku.tenant.dao.SysUserDao;
import net.maku.tenant.dto.SysTenantDTO;
import net.maku.tenant.dto.TenantUserDTO;
import net.maku.tenant.dto.UpdatePasswordDTO;
import net.maku.tenant.entity.SysTenantEntity;
import net.maku.tenant.entity.SysUserEntity;
import net.maku.tenant.query.SysTenantQuery;
import net.maku.tenant.service.SysUserRoleService;
import net.maku.tenant.service.SysUserService;
import net.maku.tenant.vo.SysTenantVO;
import net.maku.tenant.dao.SysTenantDao;
import net.maku.tenant.service.SysTenantService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 租户相关
 *
 * @author cy babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Slf4j
@Service
@AllArgsConstructor
public class SysTenantServiceImpl extends BaseServiceImpl<SysTenantDao, SysTenantEntity> implements SysTenantService {
    private final SysUserService sysUserService;
    private final SysUserRoleService sysUserRoleService;
    private final SysUserDao sysUserDao;

    @Override
    public PageResult<SysTenantVO> page(SysTenantQuery query) {
        IPage<SysTenantEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(SysTenantConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }


    private LambdaQueryWrapper<SysTenantEntity> getWrapper(SysTenantQuery query){
        LambdaQueryWrapper<SysTenantEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }


    @Override
    public SysTenantVO get(Long id) {
        SysTenantEntity entity = baseMapper.selectById(id);
        SysTenantVO vo = SysTenantConvert.INSTANCE.convert(entity);

        return vo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysTenantDTO dto) {
        String password = SmUtil.sm3("123456");
        dto.setPassword(password);
        SysTenantEntity entity = SysTenantConvert.INSTANCE.convert(dto);
        baseMapper.insert(entity);
        TenantUserDTO tenantUserDTO = new TenantUserDTO();
        tenantUserDTO.setTenantId(entity.getId());
        tenantUserDTO.setUsername(dto.getUsername());
        tenantUserDTO.setPassword(password);
        Long userId = sysUserService.addTenantAccount(tenantUserDTO);
        sysUserRoleService.addUserRole(userId,entity.getId());

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysTenantDTO dto) {
        SysTenantEntity entity = SysTenantConvert.INSTANCE.convert(dto);

        updateById(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);

    }

    @Override
    public void updatePassword(UpdatePasswordDTO dto) {
        String password =  SmUtil.sm3(dto.getNewPassword());
        // 更新租户表密码
        UpdateWrapper<SysTenantEntity> wrapper = new UpdateWrapper<>();
        wrapper.eq("id",dto.getTenantId())
                .set("password",password);
        update(wrapper);

        // 更新用户表密码
        UpdateWrapper<SysUserEntity> userWrapper = new UpdateWrapper<>();
        Long userId = sysUserRoleService.getUserId(dto.getTenantId());
        userWrapper.eq("id",userId)
                .set("password",password);
        sysUserDao.update(userWrapper);
    }


}