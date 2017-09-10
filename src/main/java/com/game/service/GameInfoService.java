package com.game.service;

import com.game.mapper.GameInfoMapper;
import com.game.model.GameInfo;
import com.game.util.SqlCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<GameInfo> getGameSearchInfo(int type,int platform,int net,int time){
        List<GameInfo> gameInfos = gameInfoMapper.getGameInfoBySearch(type,platform,net,time);

        return gameInfos;
    }

}
