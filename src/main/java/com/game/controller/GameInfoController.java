package com.game.controller;

import com.game.entity.GameInfo;
import com.game.service.GameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiayifan on 2017/9/8.
 */
@RestController
public class GameInfoController {

    @Autowired
    GameInfoService gameInfoService;

    @RequestMapping("/game")
    public String index(){
        GameInfo gameInfo = gameInfoService.showGameInfo(1);
        String string;
        string = ""+gameInfo.getName()+"/n"+gameInfo.getEnName();
        return string;
    }
}
