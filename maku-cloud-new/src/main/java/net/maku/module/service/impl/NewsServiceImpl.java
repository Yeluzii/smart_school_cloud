package net.maku.module.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.maku.framework.common.utils.Result;

import net.maku.module.entity.NewsEntity;
import net.maku.module.mapper.NewsMapper;
import net.maku.module.service.NewsService;
import net.maku.module.vo.NewsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public Result<List<NewsVO>> getBannerNews() {
        List<NewsEntity> banners = newsMapper.selectList(
                new QueryWrapper<NewsEntity>().eq("banner", 1)
                        .eq("status", 1).eq("deleted", 0)
                        .orderByDesc("create_time")
        );
        return Result.ok(transformToVOList(banners));
    }

    @Override
    public Result<List<NewsVO>> getNewsList() {
        List<NewsEntity> newsList = newsMapper.selectList(
                new QueryWrapper<NewsEntity>()
                        .eq("status", 1).eq("deleted", 0)
                        .orderByDesc("create_time")
        );
        return Result.ok(transformToVOList(newsList));
    }

    @Override
    public Result<NewsVO> getNewsDetails(Long id) {
        NewsEntity news = newsMapper.selectById(id);
        return Result.ok(transformToVO(news));
    }

    @Override
    public Result<List<NewsVO>> getAnnouncementList() {
        List<NewsEntity> announcementList = newsMapper.selectList(
                new QueryWrapper<NewsEntity>()
                        .eq("status", 1)
                        .eq("deleted", 0)
                        .eq("type", 0)
                        .orderByDesc("create_time")
        );
        return Result.ok(transformToVOList(announcementList));
    }


    @Override
    public Result<List<NewsVO>> getCampusInfoList() {
        List<NewsEntity> campusInfoList = newsMapper.selectList(
                new QueryWrapper<NewsEntity>()
                        .eq("status", 1)
                        .eq("deleted", 0)
                        .eq("type", 1)   // 只查询校园信息
                        .orderByDesc("create_time")
        );
        return Result.ok(transformToVOList(campusInfoList));
    }


    private List<NewsVO> transformToVOList(List<NewsEntity> entities) {
        return entities.stream().map(this::transformToVO).collect(Collectors.toList());
    }

    private NewsVO transformToVO(NewsEntity entity) {
        return new NewsVO(entity.getId(), entity.getTitle(), entity.getCover(), entity.getContent(), entity.getCreateTime());
    }
}
