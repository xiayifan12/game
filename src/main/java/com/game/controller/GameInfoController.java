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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


/**
 * Created by xiayifan on 2017/9/8.
 */
@Controller
public class GameInfoController {

    public static final String ROOT = "/images/";

    @Autowired
    GameInfoService gameInfoService;

    @Autowired
    ContentInfoService contentInfoService;

    @GetMapping("/game/{id}")
    public String getGameDetail(@PathVariable int id , Model mapper){

        GameInfo gameInfo = gameInfoService.getGameDetailById(id);
        mapper.addAttribute("content",contentInfoService.getContentDetailByType(0));
        mapper.addAttribute("game",gameInfo);
        return "GamePage.html";
    }

    @GetMapping("/game")
    public String getGameContentAndInfo(Model mapper ,@RequestParam(name = "type",required=false,defaultValue = "0")int type,
                                                       @RequestParam(name = "platform",required=false,defaultValue = "0")int platform,
                                                         @RequestParam(name = "net",required=false,defaultValue = "0")int net,
                                                           @RequestParam(name = "time",required=false,defaultValue = "0")int time,
                                                             @RequestParam(name = "page",required = false,defaultValue = "0")int page){

        List<ContentInfo> gameTypeInfo = contentInfoService.getContentDetailByType(0) ;
        mapper.addAttribute("type",gameTypeInfo);
        List<ContentInfo> gamePlatInfo = contentInfoService.getContentDetailByType(1);
        mapper.addAttribute("plat",gamePlatInfo);
        List<ContentInfo> gameNetInfo = contentInfoService.getContentDetailByType(2);
        mapper.addAttribute("net",gameNetInfo);
        List<ContentInfo> gameTimeInfo = contentInfoService.getContentDetailByType(3);
        mapper.addAttribute("time",gameTimeInfo);

        List<GameInfo> gameInfos = gameInfoService.getGameSearchInfo(type,platform,net,time,page);
        mapper.addAttribute("game",gameInfos);

        return "debug";
    }


    @PostMapping("/game/add")
    public String addGameInfo(@RequestParam("image") MultipartFile image,
                              @RequestParam("banner") MultipartFile banner,
                              @RequestParam("name") String name,
                              @RequestParam("enName")String enName,
                              @RequestParam("version")String version,
                              @RequestParam("platform")String platform,
                              @RequestParam("describe")String describe,
                              @RequestParam("copyright")String copyright,
                              @RequestParam("connection")int connection,
                              @RequestParam("type")int type){


        String imageName = enName+"2.jpg";
        String bannerName = enName+"1.jpg";

        try {
            Files.copy(image.getInputStream(), Paths.get(ROOT,imageName));
            Files.copy(banner.getInputStream(), Paths.get(ROOT,bannerName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        gameInfoService.addGameInfo();//没写呢！！！！  做一个年份的样式！！！！！！


        return "";
    }




}
