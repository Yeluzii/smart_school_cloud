package net.maku.tenant.convert;

import net.maku.tenant.dto.SysTenantDTO;
import net.maku.tenant.entity.SysTenantEntity;
import net.maku.tenant.vo.SysTenantVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 租户相关
 *
 * @author cy babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface SysTenantConvert {
    SysTenantConvert INSTANCE = Mappers.getMapper(SysTenantConvert.class);

    SysTenantEntity convert(SysTenantVO vo);

    SysTenantEntity convert(SysTenantDTO dto);

    SysTenantVO convert(SysTenantEntity entity);

    List<SysTenantVO> convertList(List<SysTenantEntity> list);

    List<SysTenantEntity> convertList2(List<SysTenantVO> list);

}