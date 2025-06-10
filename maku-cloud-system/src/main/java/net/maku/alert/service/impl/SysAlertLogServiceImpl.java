package net.maku.alert.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.alert.convert.SysAlertLogConvert;
import net.maku.alert.entity.SysAlertLogEntity;
import net.maku.alert.query.SysAlertLogQuery;
import net.maku.alert.vo.SysAlertLogVO;
import net.maku.alert.dao.SysAlertLogDao;
import net.maku.alert.service.SysAlertLogService;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 告警记录表
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Service
@AllArgsConstructor
public class SysAlertLogServiceImpl extends BaseServiceImpl<SysAlertLogDao, SysAlertLogEntity> implements SysAlertLogService {

    @Override
    public PageResult<SysAlertLogVO> page(SysAlertLogQuery query) {
        IPage<SysAlertLogEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(SysAlertLogConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }


    private LambdaQueryWrapper<SysAlertLogEntity> getWrapper(SysAlertLogQuery query){
        LambdaQueryWrapper<SysAlertLogEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.like(ObjectUtil.isNotEmpty(query.getAlertName()), SysAlertLogEntity::getAlertName, query.getAlertName());
        wrapper.eq(ObjectUtil.isNotEmpty(query.getAlertLevel()), SysAlertLogEntity::getAlertLevel, query.getAlertLevel());
        wrapper.eq(ObjectUtil.isNotEmpty(query.getStatus()), SysAlertLogEntity::getStatus, query.getStatus());

        return wrapper;
    }


    @Override
    public SysAlertLogVO get(Long id) {
        SysAlertLogEntity entity = baseMapper.selectById(id);
        SysAlertLogVO vo = SysAlertLogConvert.INSTANCE.convert(entity);

        return vo;
    }



    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateStatus(Long id, Integer status) {
        if (status != 0 && status != 1) {
            throw new RuntimeException("状态值不合法");
        }

        SysAlertLogEntity entity = new SysAlertLogEntity();
        entity.setId(id);
        entity.setStatus(status);

        return baseMapper.updateById(entity) > 0;
    }


}