package com.game.controller;

import com.game.service.ArticleInfoService;
import com.game.service.GameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by xiayifan on 2017/9/8.
 */
@Controller
public class HomeController {

    @Autowired
    GameInfoService gameInfoService;
    @Autowired
    ArticleInfoService articleInfoService;

    @GetMapping("/home")
    public String HomeDetail(Model mapper, HttpSession session){
        mapper.addAttribute("game",gameInfoService.getGameDetailRandom(3));
        mapper.addAttribute("user",session.getAttribute("c_user"));
        mapper.addAttribute("articles",articleInfoService.getArticleDetailRandom(3));
        return "HomePage";
    }
}
