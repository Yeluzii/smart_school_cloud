package net.maku.business.convert;

import net.maku.business.entity.TNewsEntity;
import net.maku.business.vo.TNewsVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 资讯表
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface TNewsConvert {
    TNewsConvert INSTANCE = Mappers.getMapper(TNewsConvert.class);

    TNewsEntity convert(TNewsVO vo);

    TNewsVO convert(TNewsEntity entity);

    List<TNewsVO> convertList(List<TNewsEntity> list);

    List<TNewsEntity> convertList2(List<TNewsVO> list);

}