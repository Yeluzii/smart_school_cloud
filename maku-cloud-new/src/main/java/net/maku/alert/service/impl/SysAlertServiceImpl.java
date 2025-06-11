package net.maku.alert.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.alert.convert.SysAlertConvert;
import net.maku.alert.entity.SysAlertEntity;
import net.maku.alert.query.SysAlertQuery;
import net.maku.alert.vo.SysAlertVO;
import net.maku.alert.dao.SysAlertDao;
import net.maku.alert.service.SysAlertService;
import net.maku.framework.common.utils.ExcelUtils;
import net.maku.alert.vo.SysAlertExcelVO;
import net.maku.framework.common.excel.ExcelFinishCallBack;
import net.maku.iot.vo.UserDeviceVO;
import org.springframework.web.multipart.MultipartFile;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 告警配置表
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Service
@AllArgsConstructor
public class SysAlertServiceImpl extends BaseServiceImpl<SysAlertDao, SysAlertEntity> implements SysAlertService {

    @Override
    public PageResult<SysAlertVO> page(SysAlertQuery query) {
        IPage<SysAlertEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(SysAlertConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }


    private LambdaQueryWrapper<SysAlertEntity> getWrapper(SysAlertQuery query){
        LambdaQueryWrapper<SysAlertEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.like(ObjectUtil.isNotEmpty(query.getAlertName()), SysAlertEntity::getAlertName, query.getAlertName());
        wrapper.eq(ObjectUtil.isNotEmpty(query.getAlertLevel()), SysAlertEntity::getAlertLevel, query.getAlertLevel());

        return wrapper;
    }


    @Override
    public SysAlertVO get(Long id) {
        SysAlertEntity entity = baseMapper.selectById(id);
        SysAlertVO vo = SysAlertConvert.INSTANCE.convert(entity);

        return vo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysAlertVO vo) {
        SysAlertEntity entity = SysAlertConvert.INSTANCE.convert(vo);
        baseMapper.insert(entity);


    }

    @Override
    public void batchSave(List<Long> devieceIdList, Long alertId) {
        devieceIdList.forEach(deviceId -> {
            baseMapper.batchSave(deviceId, alertId);
        });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysAlertVO vo) {
        SysAlertEntity entity = SysAlertConvert.INSTANCE.convert(vo);

        updateById(entity);


    }

    @Override
    public List<UserDeviceVO> selectDevicesByAlertId(Long alertId) {
        return baseMapper.selectDevicesByGroupId(alertId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);

    }

    @Override
    public void importByExcel(MultipartFile file) {
        ExcelUtils.readAnalysis(file, SysAlertExcelVO.class, new ExcelFinishCallBack<>() {
            @Override
            public void doSaveBatch(List<SysAlertExcelVO> resultList) {
                ExcelUtils.parseDict(resultList);
                saveBatch(SysAlertConvert.INSTANCE.convertExcelList2(resultList));
            }
        });
    }


}
