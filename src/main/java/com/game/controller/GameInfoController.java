package com.game.controller;

import com.game.service.GameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by xiayifan on 2017/9/8.
 */
@Controller
public class GameInfoController {

    @Autowired
    GameInfoService gameInfoService;

    @GetMapping("/game")
    public String index(){
        GameInfo gameInfo = gameInfoService.showGameInfo(1);
        String string;
        string = ""+gameInfo.getName()+"/n"+gameInfo.getEnName();
        return "GamePage";
    }
}
