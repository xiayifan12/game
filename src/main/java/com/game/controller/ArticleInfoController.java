package com.game.controller;

import com.game.model.ContentInfo;
import com.game.model.ArticleInfo;
import com.game.service.ArticleInfoService;
import com.game.service.ContentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by 大清自有国情在此 on 2017/9/10.
 */
public class ArticleInfoController {

    @Autowired
    ArticleInfoService articleInfoService;

    @Autowired
    ContentInfoService contentInfoService;

    @GetMapping("/aricle/{id}")
    public String getArticleDetail(@PathVariable int id , Model mapper){

        ArticleInfo gameInfo = articleInfoService.getArticleDetailById(id);
        mapper.addAttribute("game",gameInfo);
        return "ArticlePage.html";
    }

    @GetMapping("/aricle")
    public String getGameContentAndInfo(Model mapper , @RequestParam(name = "type",required=false,defaultValue = "0")int type,
                                                        @RequestParam(name = "time",required=false,defaultValue = "0")int time ){

        //ResultMap:{Status”:1 or 0,”Key”:{“Type”:Context[],”Time”:Context[]},”Article”:ArticleInfo[]}

//        List<ContentInfo> articleTypeInfo = contentInfoService.getContentDetailByType(0) ;
//        mapper.addAttribute("type", articleTypeInfo);
//        List<ContentInfo> articleTimeInfo = contentInfoService.getContentDetailByType(1);
//        mapper.addAttribute("time", articleTimeInfo);

        List<ArticleInfo> articleInfos = articleInfoService.getArticleSearchInfo(type, time);
        mapper.addAttribute("article", articleInfos);

        return "ArticlePage.html";
    }
}
