package net.maku.alert.service;

import net.maku.alert.vo.AlertLogVO;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.alert.vo.SysAlertLogVO;
import net.maku.alert.query.SysAlertLogQuery;
import net.maku.alert.entity.SysAlertLogEntity;
import java.util.List;

/**
 * 告警记录表
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
public interface SysAlertLogService extends BaseService<SysAlertLogEntity> {

    PageResult<SysAlertLogVO> page(SysAlertLogQuery query);

    SysAlertLogVO get(Long id);

    List<AlertLogVO> getAlertLogList();

    List<AlertLogVO> getAlertLogVO(Long deviceId);

    void save(Long deviceId, Object info);

}
