package net.maku.module.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.maku.framework.common.utils.Result;
import net.maku.module.entity.NewsEntity;
import net.maku.module.vo.NewsVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsMapper extends BaseMapper<NewsEntity> {

}
