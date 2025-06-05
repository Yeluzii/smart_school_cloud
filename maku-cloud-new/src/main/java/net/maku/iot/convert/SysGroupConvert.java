package net.maku.iot.convert;

import net.maku.iot.entity.SysGroupEntity;
import net.maku.iot.vo.SysGroupVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * group
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface SysGroupConvert {
    SysGroupConvert INSTANCE = Mappers.getMapper(SysGroupConvert.class);

    SysGroupEntity convert(SysGroupVO vo);

    SysGroupVO convert(SysGroupEntity entity);

    List<SysGroupVO> convertList(List<SysGroupEntity> list);

    List<SysGroupEntity> convertList2(List<SysGroupVO> list);

}