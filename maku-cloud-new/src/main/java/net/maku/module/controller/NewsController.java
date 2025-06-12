package net.maku.module.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import net.maku.framework.common.utils.Result;

import net.maku.module.service.NewsService;
import net.maku.module.vo.NewsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/banners")
    @Tag(name = "首页轮播图")
    public Result<List<NewsVO>> getBannerNews() {
        return newsService.getBannerNews();
    }

    @GetMapping("/list")
    @Tag(name = "新闻列表")
    public Result<List<NewsVO>> getNewsList() {
        return newsService.getNewsList();
    }

    @GetMapping("/details")
    @Tag(name = "新闻详情")
    public Result<NewsVO> getNewsDetails(@RequestParam Long id) {
        return newsService.getNewsDetails(id);
    }

    @GetMapping("/announcement")
    @Tag(name = "公告列表")
    public Result<List<NewsVO>> getAnnouncementList() {
        return newsService.getAnnouncementList();
    }

    @GetMapping("/campus")
    @Tag(name = "校园信息列表")
    public Result<List<NewsVO>> getCampusInfoList() {
        return newsService.getCampusInfoList();
    }

}