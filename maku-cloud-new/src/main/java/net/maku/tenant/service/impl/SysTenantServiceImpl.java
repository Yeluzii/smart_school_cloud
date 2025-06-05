package net.maku.tenant.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.tenant.convert.SysTenantConvert;
import net.maku.tenant.entity.SysTenantEntity;
import net.maku.tenant.query.SysTenantQuery;
import net.maku.tenant.vo.SysTenantVO;
import net.maku.tenant.dao.SysTenantDao;
import net.maku.tenant.service.SysTenantService;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 租户相关
 *
 * @author cy babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Service
@AllArgsConstructor
public class SysTenantServiceImpl extends BaseServiceImpl<SysTenantDao, SysTenantEntity> implements SysTenantService {

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
    public void save(SysTenantVO vo) {
        SysTenantEntity entity = SysTenantConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysTenantVO vo) {
        SysTenantEntity entity = SysTenantConvert.INSTANCE.convert(vo);

        updateById(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);

    }



}