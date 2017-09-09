package com.game.service;

import com.game.mapper.GameInfoMapper;
import com.game.model.GameInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



}
