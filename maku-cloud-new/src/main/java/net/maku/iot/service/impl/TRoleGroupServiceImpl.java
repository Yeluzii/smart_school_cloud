package net.maku.iot.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.iot.convert.TRoleGroupConvert;
import net.maku.iot.entity.TDeviceGroupEntity;
import net.maku.iot.entity.TRoleGroupEntity;
import net.maku.iot.query.TRoleGroupQuery;
import net.maku.iot.vo.DeviceVO;
import net.maku.iot.vo.RoleVO;
import net.maku.iot.vo.TRoleGroupVO;
import net.maku.iot.dao.TRoleGroupDao;
import net.maku.iot.service.TRoleGroupService;
import com.fhs.trans.service.impl.TransService;
import net.maku.framework.common.utils.ExcelUtils;
import net.maku.iot.vo.TRoleGroupExcelVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * trg
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Service
@AllArgsConstructor
public class TRoleGroupServiceImpl extends BaseServiceImpl<TRoleGroupDao, TRoleGroupEntity> implements TRoleGroupService {

    @Override
    public PageResult<TRoleGroupVO> page(TRoleGroupQuery query) {
        IPage<TRoleGroupEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(TRoleGroupConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }


    private LambdaQueryWrapper<TRoleGroupEntity> getWrapper(TRoleGroupQuery query){
        LambdaQueryWrapper<TRoleGroupEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }


    @Override
    public List<TRoleGroupVO> get(Long id) {
        List<TRoleGroupEntity> entity = baseMapper.selectList(  Wrappers.<TRoleGroupEntity>lambdaQuery().eq(TRoleGroupEntity::getClass, id));
        List<TRoleGroupVO> vo = TRoleGroupConvert.INSTANCE.convertList(entity);

        return vo;
    }
    @Override
    public List<RoleVO> selectRoleIdsByGroupId(Long groupId){
        return baseMapper.selectRoleIdsByGroupId(groupId);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(TRoleGroupVO vo) {
        TRoleGroupEntity entity = TRoleGroupConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TRoleGroupVO vo) {
        TRoleGroupEntity entity = TRoleGroupConvert.INSTANCE.convert(vo);

        updateById(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);

    }
    @Override
    public void deleteData(Long groupId,  Long roleId) {
        baseMapper.deleteData(groupId, roleId);
    }
    @Override
    public void batchSave(List<Long> roleIdList , Long groupId) {
        List<TRoleGroupEntity> list = roleIdList.stream().map(roleId -> {
            TRoleGroupEntity entity = new TRoleGroupEntity();
            entity.setRoleId(roleId);
            entity.setGroupId(groupId);
            return entity;
        }).toList();
        saveBatch(list);
    }

}
