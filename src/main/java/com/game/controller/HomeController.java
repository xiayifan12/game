package com.game.controller;

import com.game.service.GameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by xiayifan on 2017/9/8.
 */
@Controller
public class HomeController {

    @Autowired
    GameInfoService gameInfoService;

    @GetMapping("/")
    public String HomeDetail(Model mapper){
        mapper.addAttribute("game",gameInfoService.getGameDetailRandom(3));
        return "HomePage";
    }
}
