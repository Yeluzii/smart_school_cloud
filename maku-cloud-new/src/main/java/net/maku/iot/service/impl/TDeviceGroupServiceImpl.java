package net.maku.iot.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.iot.convert.TDeviceGroupConvert;
import net.maku.iot.entity.TDeviceGroupEntity;
import net.maku.iot.query.TDeviceGroupQuery;
import net.maku.iot.vo.DeviceVO;
import net.maku.iot.vo.TDeviceGroupVO;
import net.maku.iot.dao.TDeviceGroupDao;
import net.maku.iot.service.TDeviceGroupService;
import net.maku.iot.vo.UserDeviceVO;
import net.maku.iot.vo.UserGroupVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * tdg
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Service
@AllArgsConstructor
public class TDeviceGroupServiceImpl extends BaseServiceImpl<TDeviceGroupDao, TDeviceGroupEntity> implements TDeviceGroupService {

    @Override
    public PageResult<TDeviceGroupVO> page(TDeviceGroupQuery query) {
        IPage<TDeviceGroupEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(TDeviceGroupConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }


    private LambdaQueryWrapper<TDeviceGroupEntity> getWrapper(TDeviceGroupQuery query){
        LambdaQueryWrapper<TDeviceGroupEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }


    @Override
    public List<TDeviceGroupVO> get(Long groupId) {
        List<TDeviceGroupEntity> entity = baseMapper.selectList( Wrappers.<TDeviceGroupEntity>lambdaQuery().eq(TDeviceGroupEntity::getClass, groupId));
        return TDeviceGroupConvert.INSTANCE.convertList(entity);
    }

    @Override
    public List<UserGroupVO> selectGroupIdsByUserId(Long userId) {
        return baseMapper.selectGroupIdsByUserId(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(TDeviceGroupVO vo) {
        TDeviceGroupEntity entity = TDeviceGroupConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);


    }

    @Override
    public List<UserDeviceVO> selectDevicesByGroupId(Long groupId) {
        return List.of();
    }

    @Override
    public List<DeviceVO> selectDeviceIdsByGroupId(Long groupId){
        return baseMapper.selectDeviceIdsByGroupId(groupId);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TDeviceGroupVO vo) {
        TDeviceGroupEntity entity = TDeviceGroupConvert.INSTANCE.convert(vo);

        updateById(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);

    }

    @Override
    public void batchSave(List<Long> devieceIdList, Long groupId) {
        List<TDeviceGroupEntity> list = devieceIdList.stream().map(deviceId -> {
            TDeviceGroupEntity entity = new TDeviceGroupEntity();
            entity.setDeviceId(deviceId);
            entity.setGroupId(groupId);
            return entity;
        }).toList();
        saveBatch(list);
    }

}
