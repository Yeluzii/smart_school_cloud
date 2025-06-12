package net.maku.iot.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.iot.vo.DeviceVO;
import net.maku.iot.vo.RoleVO;
import net.maku.iot.vo.TRoleGroupVO;
import net.maku.iot.query.TRoleGroupQuery;
import net.maku.iot.entity.TRoleGroupEntity;
import java.util.List;

/**
 * trg
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
public interface TRoleGroupService extends BaseService<TRoleGroupEntity> {

    PageResult<TRoleGroupVO> page(TRoleGroupQuery query);

    List<TRoleGroupVO> get(Long id);

    List<RoleVO> selectRoleIdsByGroupId(Long groupId);
    void save(TRoleGroupVO vo);
    void batchSave(List<Long> roleIdList, Long groupId);
    void update(TRoleGroupVO vo);

    void delete(List<Long> idList);
    void deleteData(Long groupId, Long deviceId);
}
