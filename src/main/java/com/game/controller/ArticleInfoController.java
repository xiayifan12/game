package com.game.controller;

import com.game.model.ArticleInfo;
import com.game.model.GameInfo;
import com.game.model.UserInfo;
import com.game.service.ArticleInfoService;
import com.game.service.ContentInfoService;
import com.game.service.GameInfoService;
import com.game.util.ArticleForm;
import com.game.util.ArticleJson;
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

    @Autowired
    GameInfoService gameInfoService;

    @GetMapping("/article/{id}")
    public String getArticleDetail(@PathVariable int id , Model mapper,HttpSession session){

        ArticleInfo articleInfo = articleInfoService.getArticleDetailById(id);
        mapper.addAttribute("article",articleInfo);
        mapper.addAttribute("user",session.getAttribute("c_user"));
        return "ArticlePage.html";
    }

    @GetMapping("/article")
    public String searchArticleByName(){
        return "ArticleSearchPage";
    }

    @GetMapping("/article/flash")
    @ResponseBody
    public ArticleJson SearchPageForAjax(@RequestParam(name = "title") String title){

            ArticleJson msg = new ArticleJson();

            List<ArticleInfo> articles = articleInfoService.getArticleDetailByTitle(title);

            msg.articles=articles;

            msg.size= articles.size();

            return msg;

    }

//    @GetMapping("/article")
//    public String getGameContentAndInfo(Model mapper , @RequestParam(name = "type",required=false,defaultValue = "0")int type,
//                                                        @RequestParam(name = "time",required=false,defaultValue = "0")int time ){
//
//        //ResultMap:{Status”:1 or 0,”Key”:{“Type”:Context[],”Time”:Context[]},”Article”:ArticleInfo[]}
//
////        List<ContentInfo> articleTypeInfo = contentInfoService.getContentDetailByType(0) ;
////        mapper.addAttribute("type", articleTypeInfo);
////        List<ContentInfo> articleTimeInfo = contentInfoService.getContentDetailByType(1);
////        mapper.addAttribute("time", articleTimeInfo);
//
//        List<ArticleInfo> articleInfos = articleInfoService.getArticleSearchInfo(type, time);
//        mapper.addAttribute("article", articleInfos);
//
//        return "ArticlePage.html";
//    }

    @GetMapping("/article/add")
    public String postArticle(HttpSession httpSession,Model model) {
        model.addAttribute("user",httpSession.getAttribute("c_user"));
        return "ArticleEdit";
    }

    @PostMapping("/article/add/up")
    @ResponseBody
    public StatusJson addNewArticle (@RequestParam("title")String title,@RequestParam("field")String field,@RequestParam("game")String game,HttpSession session){
        StatusJson statusJson = new StatusJson();
        UserInfo author = (UserInfo) session.getAttribute("c_user");
        GameInfo gameinfo = gameInfoService.getGameDetailByname(game);
        if(field!=null&&title!=null) {
            if (gameinfo==null) {statusJson.status=0;  return statusJson; }
            articleInfoService.addNewArticle(title,field,gameinfo.getId(),author.getId());
            statusJson.status=1;
        }
        else {
            statusJson.status=0;
        }
        return statusJson;

    }

    @GetMapping("/article/update/{id}")
    public String ShowUpdatePage(@PathVariable("id")int articleId,Model mapper,HttpSession session){

        mapper.addAttribute("articleId",articleId);
        mapper.addAttribute("user",session.getAttribute("c_user"));
        return "ArticleUpdate";
    }

    @PostMapping("/article/update/up")
    @ResponseBody
    public StatusJson updateArticle(@RequestParam("articleId")int articleId,@RequestParam("field")String  field){

        StatusJson statusJson = new StatusJson();

        statusJson.status = 1;

        articleInfoService.updateArticleById(articleId,field);

        return statusJson;

    }

    @GetMapping("/article/delete")
    @ResponseBody
    public StatusJson deleteArticle(@RequestParam("articleId")int articleId){

        StatusJson statusJson = new StatusJson();
        articleInfoService.deleteArticleById(articleId);
        statusJson.status = 1;
        return statusJson;

    }







}
