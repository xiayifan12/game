package com.game.controller;

import com.game.model.ArticleInfo;
import com.game.service.ArticleInfoService;
import com.game.service.ContentInfoService;
import com.game.util.ArticleForm;
import com.game.util.StatusJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 大清自有国情在此 on 2017/9/10.
 */
@Controller
public class ArticleInfoController {

    @Autowired
    ArticleInfoService articleInfoService;

    @Autowired
    ContentInfoService contentInfoService;

    @GetMapping("/article/{id}")
    public String getArticleDetail(@PathVariable int id , Model mapper){

        ArticleInfo articleInfo = articleInfoService.getArticleDetailById(id);
        System.out.print(articleInfo.getContent());
        mapper.addAttribute("article",articleInfo);
        return "ArticlePage.html";
    }

    @GetMapping("/article")
    public String getGameContentAndInfo(Model mapper , @RequestParam(name = "type", required = false, defaultValue = "0") int type,
                                                        @RequestParam(name = "name",required=false,defaultValue = "0")String name,   //need?
                                                        @RequestParam(name = "time",required=false,defaultValue = "0")int time){

        //ResultMap:{Status”:1 or 0,”Key”:{“Type”:Context[],”Time”:Context[]},”Article”:ArticleInfo[]}

//        List<ContentInfo> articleTypeInfo = contentInfoService.getContentDetailByType(0) ;
//        mapper.addAttribute("type", articleTypeInfo);
//        List<ContentInfo> articleTimeInfo = contentInfoService.getContentDetailByType(1);
//        mapper.addAttribute("time", articleTimeInfo);

        //
        List<ArticleInfo> articleInfos = articleInfoService.getArticleSearchInfo(type, name, time);
        mapper.addAttribute("article", articleInfos);

        return "ArticlePage.html";
    }

    @GetMapping("/article/add")
    public String postArticle(HttpSession httpSession,Model model) {
        model.addAttribute("user",httpSession.getAttribute("c_user"));
        return "ArticleEdit";
    }

    @PostMapping("/article/add/up")
    @ResponseBody
    public StatusJson addNewArticle (@RequestBody ArticleForm data){
        StatusJson statusJson = new StatusJson();

        if(data.field!=null&&data.title!=null) {
            statusJson.status=1;
//            articleInfoService.

        }
        else {
            statusJson.status=0;
        }
        return statusJson;

    }






}
