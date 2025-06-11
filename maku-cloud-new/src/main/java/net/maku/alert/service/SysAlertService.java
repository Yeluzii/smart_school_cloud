package net.maku.alert.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.alert.vo.SysAlertVO;
import net.maku.alert.query.SysAlertQuery;
import net.maku.alert.entity.SysAlertEntity;
import net.maku.iot.vo.UserDeviceVO;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

/**
 * 告警配置表
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
public interface SysAlertService extends BaseService<SysAlertEntity> {

    PageResult<SysAlertVO> page(SysAlertQuery query);

    SysAlertVO get(Long id);


    void save(SysAlertVO vo);
    void batchSave(List<Long> devieceIdList, Long groupId);
    void update(SysAlertVO vo);
    List<UserDeviceVO> selectDevicesByAlertId(Long alertId);
    void delete(List<Long> idList);
    void importByExcel(MultipartFile file);

}
