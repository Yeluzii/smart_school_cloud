package net.maku.iot.convert;

import net.maku.iot.entity.TDeviceGroupEntity;
import net.maku.iot.vo.TDeviceGroupVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * tdg
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface TDeviceGroupConvert {
    TDeviceGroupConvert INSTANCE = Mappers.getMapper(TDeviceGroupConvert.class);

    TDeviceGroupEntity convert(TDeviceGroupVO vo);

    TDeviceGroupVO convert(TDeviceGroupEntity entity);

    List<TDeviceGroupVO> convertList(List<TDeviceGroupEntity> list);

    List<TDeviceGroupEntity> convertList2(List<TDeviceGroupVO> list);

}