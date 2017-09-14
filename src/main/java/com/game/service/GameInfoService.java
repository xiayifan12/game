package com.game.service;

import com.game.mapper.GameInfoMapper;
import com.game.model.GameInfo;
import com.game.util.SqlCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by xiayifan on 2017/9/8.
 */
@Service
public class GameInfoService {

    @Autowired
    GameInfoMapper gameInfoMapper;

    public GameInfo getGameDetailById(int id){
        return gameInfoMapper.getGameInfoById(id);
    }

    public GameInfo getGameDetailByname(String name){return gameInfoMapper.getGameInfoByName(name);}

    public List<GameInfo> getGameSearchInfo(int type,int platform,int net,int time,int page){
        List<GameInfo> gameInfos = gameInfoMapper.getGameInfoBySearch(type,platform,net,time,page);

        return gameInfos;
    }

    public List<GameInfo> getGameDetailRandom(int num){

        Integer count = gameInfoMapper.getCountGameInfo();
        int rnum = new Random().nextInt(count-2);
        return gameInfoMapper.getGameInfoRandom(rnum,num);

    }

    public void addGameInfo(String name, String enName, String version, String platform, String describe, String copyright,int connection,int type, Date date, String bannerName, String imageName){

        gameInfoMapper.insertGameInfo(name,enName,platform,version,connection,describe,copyright,type,imageName,date,bannerName);
    }

    public void deleteGameInfoById(int gameId){
        gameInfoMapper.deleteGameInfoById(gameId);
    }

    public void updateVersionById(int gameId,String version){
        gameInfoMapper.updateGameInfoById(version,gameId);
    }



}
