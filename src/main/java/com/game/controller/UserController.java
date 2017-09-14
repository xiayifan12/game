package com.game.controller;

import com.game.model.GameInfo;
import com.game.service.GameUserRelationService;
import com.game.service.UserInfoService;
import com.game.util.LoginForm;
import com.game.util.StatusJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

/**
 * Created by xiayifan on 2017/9/8.
 */
@Controller
public class UserController {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    GameUserRelationService gameUserRelationService;

    @GetMapping("/")
    public String index(){
        return "login";
    }

    @GetMapping("/user/{id}")
    public String userHome(@PathVariable int id, HttpSession session, Model mapper){

       List <GameInfo>  games = gameUserRelationService.getGamesRelation2User(id);
        mapper.addAttribute("user",session.getAttribute("c_user"));
        mapper.addAttribute("games",games);
        return "PersonalPage";
    }

    @PostMapping("/login")
    @ResponseBody
    public StatusJson dealLogin(@RequestBody LoginForm data, HttpSession session){

        StatusJson statusJson = new StatusJson();
        if(userInfoService.verifyUser(data.user,data.password)==1){
            statusJson.status = 1;
            session.setAttribute("c_user",userInfoService.getUserByName(data.user));
            return statusJson;
        }
        else{
            statusJson.status = 0;
            return statusJson;
        }
    }

    @PostMapping("/register")
    @ResponseBody
    public StatusJson dealRegister(@RequestParam("user") String user,@RequestParam("password")String password ,@RequestParam("pri")String pri,@RequestParam("email")String email,HttpSession httpSession){

        StatusJson statusJson = new StatusJson();
        if(userInfoService.verifyUser(user)==0){
            statusJson.status = 0;
        }
        else{
            if(Objects.equals(pri, "bibi")){
                userInfoService.addUser(user,password,email,1);
                statusJson.status = 2;
            }
            else{
                userInfoService.addUser(user,password,email,0);
                statusJson.status = 1;

            }
        }
        return statusJson;
    }

    @PostMapping("/find")
    @ResponseBody
    public StatusJson changePasswd(@RequestParam("user") String user,@RequestParam("password")String password ,@RequestParam("email")String email){

        StatusJson statusJson = new StatusJson();

        if(userInfoService.verifyUser(user)==1){
            statusJson.status = 0;
        }
        else{
            if(userInfoService.verifyUserAndEmail(user, email)==0) statusJson.status = 0;
            else {
                statusJson.status = 1;
                userInfoService.updatePsw(email,password);
            }

        }
        return statusJson;
    }







}
