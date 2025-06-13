package net.maku.iot.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.framework.security.user.SecurityUser;
import net.maku.iot.convert.SysGroupConvert;
import net.maku.iot.entity.SysGroupEntity;
import net.maku.iot.query.SysGroupQuery;
import net.maku.iot.vo.SysGroupVO;
import net.maku.iot.dao.SysGroupDao;
import net.maku.iot.service.SysGroupService;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * group
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Service
@AllArgsConstructor
public class SysGroupServiceImpl extends BaseServiceImpl<SysGroupDao, SysGroupEntity> implements SysGroupService {

    @Override
    public PageResult<SysGroupVO> page(SysGroupQuery query) {
        IPage<SysGroupEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(SysGroupConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }


    private LambdaQueryWrapper<SysGroupEntity> getWrapper(SysGroupQuery query) {
        LambdaQueryWrapper<SysGroupEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(ObjectUtil.isNotEmpty(query.getName()), SysGroupEntity::getName, query.getName());
        wrapper.eq(ObjectUtil.isNotEmpty(query.getTenantId()), SysGroupEntity::getTenantId, query.getTenantId());
        wrapper.eq(ObjectUtil.isNotEmpty(query.getInfo()), SysGroupEntity::getInfo, query.getInfo());

        return wrapper;
    }


    @Override
    public SysGroupVO get(Long id) {
        SysGroupEntity entity = baseMapper.selectById(id);
        SysGroupVO vo = SysGroupConvert.INSTANCE.convert(entity);

        return vo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysGroupVO vo) {
        SysGroupEntity entity = SysGroupConvert.INSTANCE.convert(vo);
        entity.setTenantId(Objects.requireNonNull(SecurityUser.getUser()).getTenantId());
        baseMapper.insert(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysGroupVO vo) {
        SysGroupEntity entity = SysGroupConvert.INSTANCE.convert(vo);

        updateById(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);

    }


}