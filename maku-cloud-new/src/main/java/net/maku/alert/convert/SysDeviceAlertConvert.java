package net.maku.alert.convert;

import net.maku.alert.entity.SysDeviceAlertEntity;
import net.maku.alert.vo.SysDeviceAlertVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * d
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface SysDeviceAlertConvert {
    SysDeviceAlertConvert INSTANCE = Mappers.getMapper(SysDeviceAlertConvert.class);

    SysDeviceAlertEntity convert(SysDeviceAlertVO vo);

    SysDeviceAlertVO convert(SysDeviceAlertEntity entity);

    List<SysDeviceAlertVO> convertList(List<SysDeviceAlertEntity> list);

    List<SysDeviceAlertEntity> convertList2(List<SysDeviceAlertVO> list);

}
