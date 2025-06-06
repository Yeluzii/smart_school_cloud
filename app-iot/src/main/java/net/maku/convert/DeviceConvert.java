package net.maku.convert;

import net.maku.dto.DeviceDTO;
import net.maku.entity.Device;
import net.maku.vo.DeviceVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DeviceConvert {
    DeviceConvert INSTANCE = Mappers.getMapper(DeviceConvert.class);

    Device convert(DeviceDTO deviceDTO);

    DeviceVO convert(Device device);

    List<DeviceVO> convertList(List<Device> list);
}
