package net.maku.iot.convert;

import net.maku.iot.entity.TRoleGroupEntity;
import net.maku.iot.vo.TRoleGroupVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * trg
 *
 * @author zjp babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface TRoleGroupConvert {
    TRoleGroupConvert INSTANCE = Mappers.getMapper(TRoleGroupConvert.class);

    TRoleGroupEntity convert(TRoleGroupVO vo);

    TRoleGroupVO convert(TRoleGroupEntity entity);

    List<TRoleGroupVO> convertList(List<TRoleGroupEntity> list);

    List<TRoleGroupEntity> convertList2(List<TRoleGroupVO> list);
}
