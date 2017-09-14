package com.game.controller;


import com.game.model.ContentInfo;
import com.game.model.GameInfo;
import com.game.model.UserInfo;
import com.game.service.ArticleInfoService;
import com.game.service.ContentInfoService;
import com.game.service.GameInfoService;
import com.game.service.GameUserRelationService;
import com.game.util.GameJson;
import com.game.util.StatusJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class GameInfoController {

    public static final String ROOT = "D:\\code\\java\\gameWebForDatabase\\target\\classes\\static\\images\\";

    @Autowired
    GameInfoService gameInfoService;

    @Autowired
    ContentInfoService contentInfoService;

    @Autowired
    GameUserRelationService gameUserRelationService;

    @Autowired
    ArticleInfoService articleInfoService;

    @GetMapping("/game/{id}")
    public String getGameDetail(@PathVariable int id, Model mapper,HttpSession session) {

        GameInfo gameInfo = gameInfoService.getGameDetailById(id);
        mapper.addAttribute("content", contentInfoService.getContentDetailByType(0));
        mapper.addAttribute("game", gameInfo);
        mapper.addAttribute("articles",articleInfoService.getArticleDetailByGame(gameInfo.getId()));
        mapper.addAttribute("user",session.getAttribute("c_user"));
        return "GamePage.html";
    }

    @GetMapping("/game")
    public String getGameContentAndInfo(Model mapper, @RequestParam(name = "type", required = false, defaultValue = "0") int type,
                                        @RequestParam(name = "platform", required = false, defaultValue = "0") int platform,
                                        @RequestParam(name = "net", required = false, defaultValue = "0") int net,
                                        @RequestParam(name = "time", required = false, defaultValue = "0") int time,
                                        @RequestParam(name = "page", required = false, defaultValue = "0") int page) {

        List<ContentInfo> gameTypeInfo = contentInfoService.getContentDetailByType(0);
        mapper.addAttribute("type", gameTypeInfo);
        List<ContentInfo> gamePlatInfo = contentInfoService.getContentDetailByType(1);
        mapper.addAttribute("plat", gamePlatInfo);
        List<ContentInfo> gameNetInfo = contentInfoService.getContentDetailByType(2);
        mapper.addAttribute("net", gameNetInfo);
        List<ContentInfo> gameTimeInfo = contentInfoService.getContentDetailByType(3);
        mapper.addAttribute("time", gameTimeInfo);



        List<GameInfo> gameInfos = gameInfoService.getGameSearchInfo(type, platform, net, time, page);
        mapper.addAttribute("games", gameInfos);

        mapper.addAttribute("page",0);

        return "GameSearchPage";
    }

    @GetMapping("/game/flash")
    @ResponseBody
    public GameJson SearchPageForAjax(@RequestParam(name = "type", required = false, defaultValue = "0") int type,
                                    @RequestParam(name = "platform", required = false, defaultValue = "0") int platform,
                                    @RequestParam(name = "net", required = false, defaultValue = "0") int net,
                                    @RequestParam(name = "time", required = false, defaultValue = "0") int time,
                                    @RequestParam(name = "page", required = false, defaultValue = "0") int page){

        GameJson gameJson = new GameJson();
        gameJson.status = 1;
        gameJson.games = gameInfoService.getGameSearchInfo(type,platform,net,time,page);
        gameJson.size = gameJson.games.size();
        return gameJson;
    }


    @GetMapping("/game/add")
    public String addGameform() {
        return "GameAddPage";
    }


    @PostMapping("/game/add/up")
    public String addGameInfo(@RequestParam("image") MultipartFile image,
                              @RequestParam("banner") MultipartFile banner,
                              @RequestParam("name") String name,
                              @RequestParam("enName") String enName,
                              @RequestParam("version") String version,
                              @RequestParam("platform") String platform,
                              @RequestParam("describe") String describe,
                              @RequestParam("copyright") String copyright,
                              @RequestParam("connection") int connection,
                              @RequestParam("type") int type,
                              @RequestParam("year") int year,
                              @RequestParam("month") int month,
                              @RequestParam("day") int day) throws IOException {



        String imageName = enName + "2.jpg";
        String bannerName = enName + "1.jpg";
        String dateString = year + "-" + month + "-" + day;
        try {
            Date date = (new SimpleDateFormat("yyyy-MM-dd").parse(dateString));
            gameInfoService.addGameInfo(name, enName, version, platform, describe, copyright, connection, type, date, bannerName, imageName);
            Files.copy(image.getInputStream(), Paths.get(ROOT,imageName));
            Files.copy(banner.getInputStream(), Paths.get(ROOT,bannerName));
            gameInfoService.getGameDetailByname(name).getId();
            return "redirect:/game/"+gameInfoService.getGameDetailByname(name).getId();

        } catch (ParseException e) {
            e.printStackTrace();
            return "404";

        }
    }




    @GetMapping("/game/like")
    @ResponseBody
    public StatusJson AddCancelRelationForGame(@RequestParam("gameId") int gameId,HttpSession session){

        StatusJson statusJson = new StatusJson();
        UserInfo user = (UserInfo) session.getAttribute("c_user");
        statusJson.status = gameUserRelationService.CancelOrAddRelation(gameId,user.getId());

        return statusJson;
    }

    @GetMapping("/game/delete")
    @ResponseBody
    public StatusJson deleteGaame(@RequestParam("gameid") int gameId){

        StatusJson statusJson = new StatusJson();

        if (gameInfoService.getGameDetailById(gameId)==null){
            statusJson.status=0;
        }
        else {
            gameInfoService.deleteGameInfoById(gameId);
            statusJson.status=1;
        }
        return statusJson;
    }


    @PostMapping("/game/update")
    @ResponseBody
    public StatusJson updateGame(@RequestParam("gameId")int gameId,@RequestParam("version")String version){

        StatusJson statusJson = new StatusJson();

        statusJson.status = 1;

        gameInfoService.updateVersionById(gameId,version);

        return statusJson;


    }




}