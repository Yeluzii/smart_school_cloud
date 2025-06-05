package net.maku.tenant.convert;

import net.maku.tenant.entity.SysPackageEntity;
import net.maku.tenant.vo.SysPackageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 套餐管理
 *
 * @author cy babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface SysPackageConvert {
    SysPackageConvert INSTANCE = Mappers.getMapper(SysPackageConvert.class);

    SysPackageEntity convert(SysPackageVO vo);

    SysPackageVO convert(SysPackageEntity entity);

    List<SysPackageVO> convertList(List<SysPackageEntity> list);

    List<SysPackageEntity> convertList2(List<SysPackageVO> list);

}