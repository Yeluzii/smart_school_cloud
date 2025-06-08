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
import net.maku.tenant.dto.SysTenantDTO;
import net.maku.tenant.dto.TenantUserDTO;
import net.maku.tenant.dto.UpdatePasswordDTO;
import net.maku.tenant.entity.SysTenantEntity;
import net.maku.tenant.entity.SysUserEntity;
import net.maku.tenant.query.SysTenantQuery;
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
        dto.setPassword(SmUtil.sm3(dto.getPassword()));
        SysTenantEntity entity = SysTenantConvert.INSTANCE.convert(dto);
        baseMapper.insert(entity);
        TenantUserDTO tenantUserDTO = new TenantUserDTO();
        tenantUserDTO.setTenantId(entity.getId());
        tenantUserDTO.setUsername(dto.getUsername());
        tenantUserDTO.setPassword("123456");
        sysUserService.addTenantAccount(tenantUserDTO);

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
        UpdateWrapper<SysTenantEntity> wrapper = new UpdateWrapper<>();
        wrapper.eq("id",dto.getTenantId())
                .set("password",SmUtil.sm3(dto.getNewPassword()));
        update(wrapper);
    }


}