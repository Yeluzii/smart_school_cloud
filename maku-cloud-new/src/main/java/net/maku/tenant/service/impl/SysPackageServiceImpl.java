package net.maku.tenant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.tenant.convert.SysPackageConvert;
import net.maku.tenant.entity.SysPackageEntity;
import net.maku.tenant.query.SysPackageQuery;
import net.maku.tenant.vo.SysPackageVO;
import net.maku.tenant.dao.SysPackageDao;
import net.maku.tenant.service.SysPackageService;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 套餐管理
 *
 * @author cy babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Service
@AllArgsConstructor
public class SysPackageServiceImpl extends BaseServiceImpl<SysPackageDao, SysPackageEntity> implements SysPackageService {

    @Override
    public List<SysPackageVO> getPackageList(String name) {
        QueryWrapper<SysPackageEntity> queryWrapper = new QueryWrapper<>();
        if (name != null && !name.isEmpty()) {
            queryWrapper.eq("tenant_name", name);
        }
        List<SysPackageEntity> sysPackageEntities = baseMapper.selectList(queryWrapper);
        return SysPackageConvert.INSTANCE.convertList(sysPackageEntities);
    }

    @Override
    public PageResult<SysPackageVO> page(SysPackageQuery query) {
        IPage<SysPackageEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(SysPackageConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }


    private LambdaQueryWrapper<SysPackageEntity> getWrapper(SysPackageQuery query){
        LambdaQueryWrapper<SysPackageEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }


    @Override
    public SysPackageVO get(Long id) {
        SysPackageEntity entity = baseMapper.selectById(id);
        SysPackageVO vo = SysPackageConvert.INSTANCE.convert(entity);

        return vo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysPackageVO vo) {
        SysPackageEntity entity = SysPackageConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysPackageVO vo) {
        SysPackageEntity entity = SysPackageConvert.INSTANCE.convert(vo);

        updateById(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);

    }



}