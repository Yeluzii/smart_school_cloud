package net.maku.alert.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.alert.vo.AlertLogVO;
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

        return wrapper;
    }


    @Override
    public SysAlertLogVO get(Long id) {
        SysAlertLogEntity entity = baseMapper.selectById(id);
        SysAlertLogVO vo = SysAlertLogConvert.INSTANCE.convert(entity);

        return vo;
    }

    @Override
    public List<AlertLogVO> getAlertLogList() {
        return baseMapper.getAlertLogList();
    }


}
