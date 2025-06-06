package net.maku.module.service;

import net.maku.framework.common.utils.Result;
import net.maku.module.vo.NewsVO;

import java.util.List;

public interface NewsService {
    Result<List<NewsVO>> getBannerNews();
    Result<List<NewsVO>> getNewsList();
    Result<NewsVO> getNewsDetails(Long id);
    Result<List<NewsVO>> getAnnouncementList();
    Result<List<NewsVO>> getCampusInfoList();

}
