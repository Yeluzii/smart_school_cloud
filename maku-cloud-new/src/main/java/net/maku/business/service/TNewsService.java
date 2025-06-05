package net.maku.business.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.business.vo.TNewsVO;
import net.maku.business.query.TNewsQuery;
import net.maku.business.entity.TNewsEntity;
import java.util.List;

/**
 * 资讯表
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
public interface TNewsService extends BaseService<TNewsEntity> {

    PageResult<TNewsVO> page(TNewsQuery query);

    TNewsVO get(Long id);


    void save(TNewsVO vo);

    void update(TNewsVO vo);

    void delete(List<Long> idList);


}