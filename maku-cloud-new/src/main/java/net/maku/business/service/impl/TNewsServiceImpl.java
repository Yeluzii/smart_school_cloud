package net.maku.business.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.business.convert.TNewsConvert;
import net.maku.business.entity.TNewsEntity;
import net.maku.business.query.TNewsQuery;
import net.maku.business.vo.TNewsVO;
import net.maku.business.dao.TNewsDao;
import net.maku.business.service.TNewsService;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 资讯表
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Service
@AllArgsConstructor
public class TNewsServiceImpl extends BaseServiceImpl<TNewsDao, TNewsEntity> implements TNewsService {

    @Override
    public PageResult<TNewsVO> page(TNewsQuery query) {
        IPage<TNewsEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(TNewsConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }


    private LambdaQueryWrapper<TNewsEntity> getWrapper(TNewsQuery query){
        LambdaQueryWrapper<TNewsEntity> wrapper = Wrappers.lambdaQuery();

        if (query.getBa nner() != null) {
            wrapper.eq(TNewsEntity::getBanner, query.getBanner());
        }
        if (query.getStatus() != null) {
            wrapper.eq(TNewsEntity::getStatus, query.getStatus());
        }
        if (query.getIstop() != null) {
            wrapper.eq(TNewsEntity::getIstop, query.getIstop());
        }
        if (query.getType() != null) {
            wrapper.eq(TNewsEntity::getType, query.getType());
        }

        return wrapper;
    }


    @Override
    public TNewsVO get(Long id) {
        TNewsEntity entity = baseMapper.selectById(id);
        TNewsVO vo = TNewsConvert.INSTANCE.convert(entity);

        return vo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(TNewsVO vo) {
        TNewsEntity entity = TNewsConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TNewsVO vo) {
        TNewsEntity entity = TNewsConvert.INSTANCE.convert(vo);

        updateById(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);

    }



}