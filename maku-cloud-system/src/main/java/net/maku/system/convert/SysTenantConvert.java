package net.maku.system.convert;

import net.maku.system.entity.SysTenantEntity;
import net.maku.system.vo.TenantVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysTenantConvert {
    SysTenantConvert INSTANCE = Mappers.getMapper(SysTenantConvert.class);
    List<TenantVO> convertList(List<SysTenantEntity> list);
}
