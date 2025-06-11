package net.maku.alert.convert;

import net.maku.alert.entity.SysAlertLogEntity;
import net.maku.alert.vo.SysAlertLogVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 告警记录表
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface SysAlertLogConvert {
    SysAlertLogConvert INSTANCE = Mappers.getMapper(SysAlertLogConvert.class);

    SysAlertLogEntity convert(SysAlertLogVO vo);

    SysAlertLogVO convert(SysAlertLogEntity entity);

    List<SysAlertLogVO> convertList(List<SysAlertLogEntity> list);

    List<SysAlertLogEntity> convertList2(List<SysAlertLogVO> list);

}