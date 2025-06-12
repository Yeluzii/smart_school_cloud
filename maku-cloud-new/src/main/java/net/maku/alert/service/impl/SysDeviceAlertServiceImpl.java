package net.maku.alert.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.alert.convert.SysDeviceAlertConvert;
import net.maku.alert.entity.SysDeviceAlertEntity;
import net.maku.alert.query.SysDeviceAlertQuery;
import net.maku.alert.vo.SysDeviceAlertVO;
import net.maku.alert.dao.SysDeviceAlertDao;
import net.maku.alert.service.SysDeviceAlertService;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * d
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Service
@AllArgsConstructor
public class SysDeviceAlertServiceImpl extends BaseServiceImpl<SysDeviceAlertDao, SysDeviceAlertEntity> implements SysDeviceAlertService {

    @Override
    public PageResult<SysDeviceAlertVO> page(SysDeviceAlertQuery query) {
        IPage<SysDeviceAlertEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(SysDeviceAlertConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }


    private LambdaQueryWrapper<SysDeviceAlertEntity> getWrapper(SysDeviceAlertQuery query){
        LambdaQueryWrapper<SysDeviceAlertEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }


    @Override
    public SysDeviceAlertVO get(Long id) {
        SysDeviceAlertEntity entity = baseMapper.selectById(id);
        SysDeviceAlertVO vo = SysDeviceAlertConvert.INSTANCE.convert(entity);

        return vo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysDeviceAlertVO vo) {
        SysDeviceAlertEntity entity = SysDeviceAlertConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysDeviceAlertVO vo) {
        SysDeviceAlertEntity entity = SysDeviceAlertConvert.INSTANCE.convert(vo);

        updateById(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);

    }



}
