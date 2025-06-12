package net.maku.alert.convert;

import net.maku.alert.entity.SysAlertEntity;
import net.maku.alert.vo.SysAlertVO;
import net.maku.alert.vo.SysAlertExcelVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 告警配置表
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface SysAlertConvert {
    SysAlertConvert INSTANCE = Mappers.getMapper(SysAlertConvert.class);

    SysAlertEntity convert(SysAlertVO vo);

    SysAlertVO convert(SysAlertEntity entity);

    List<SysAlertVO> convertList(List<SysAlertEntity> list);

    List<SysAlertEntity> convertList2(List<SysAlertVO> list);

    List<SysAlertExcelVO> convertExcelList(List<SysAlertEntity> list);

    List<SysAlertEntity> convertExcelList2(List<SysAlertExcelVO> list);
}