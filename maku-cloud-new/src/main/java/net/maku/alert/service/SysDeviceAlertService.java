package net.maku.alert.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.alert.vo.SysDeviceAlertVO;
import net.maku.alert.query.SysDeviceAlertQuery;
import net.maku.alert.entity.SysDeviceAlertEntity;
import java.util.List;

/**
 * d
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
public interface SysDeviceAlertService extends BaseService<SysDeviceAlertEntity> {

    PageResult<SysDeviceAlertVO> page(SysDeviceAlertQuery query);

    SysDeviceAlertVO get(Long id);


    void save(SysDeviceAlertVO vo);

    void update(SysDeviceAlertVO vo);

    void delete(List<Long> idList);


}
