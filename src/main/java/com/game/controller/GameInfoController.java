package com.game.controller;


import com.game.model.ContentInfo;
import com.game.model.GameInfo;
import com.game.service.ContentInfoService;
import com.game.service.GameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by xiayifan on 2017/9/8.
 */
@Controller
public class GameInfoController {

    @Autowired
    GameInfoService gameInfoService;

    @Autowired
    ContentInfoService contentInfoService;

    @GetMapping("/game/{id}")
    public String getGameDetail(@PathVariable int id , Model mapper){

        GameInfo gameInfo = gameInfoService.getGameDetailById(id);
        ContentInfo contentInfo = contentInfoService.getContentDetailByType(gameInfo.getType());
        mapper.addAttribute("content",contentInfo);
        mapper.addAttribute("game",gameInfo);
        return "GamePage.html";
    }

    @GetMapping("/game")
    public String getGameSearchPage(){


        return "GameSearchPage.html";
    }

    @GetMapping("/game/{platform}/{type}/{net}/{language}")
    public String getGameSearchResult(){


        return "GameSearchPage.html";
    }
}
