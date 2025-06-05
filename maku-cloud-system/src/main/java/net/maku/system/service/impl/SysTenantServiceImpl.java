package net.maku.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.system.convert.SysTenantConvert;
import net.maku.system.dao.SysTenantDao;
import net.maku.system.entity.SysTenantEntity;
import net.maku.system.service.SysTenantService;
import net.maku.system.vo.TenantVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysTenantServiceImpl extends BaseServiceImpl<SysTenantDao, SysTenantEntity> implements SysTenantService {
    @Override
    public List<TenantVO> getTenantList(String name) {
        QueryWrapper<SysTenantEntity> queryWrapper = new QueryWrapper<>();
        if (name != null) {
            queryWrapper.like("tenant_name", name);
        }
        List<SysTenantEntity> list = baseMapper.selectList(queryWrapper);
        return SysTenantConvert.INSTANCE.convertList(list);
    }
}
