package net.maku.iot.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.iot.vo.DeviceVO;
import net.maku.iot.vo.TDeviceGroupVO;
import net.maku.iot.query.TDeviceGroupQuery;
import net.maku.iot.entity.TDeviceGroupEntity;
import java.util.List;

/**
 * tdg
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
public interface TDeviceGroupService extends BaseService<TDeviceGroupEntity> {

    PageResult<TDeviceGroupVO> page(TDeviceGroupQuery query);

    List<TDeviceGroupVO> get(Long id);

    List<DeviceVO> selectDeviceIdsByGroupId(Long groupId);
    void save(TDeviceGroupVO vo);

    void update(TDeviceGroupVO vo);

    void delete(List<Long> idList);

    void batchSave(List<Long> devieceIdList, Long groupId);
}
