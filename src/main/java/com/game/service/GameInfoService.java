package com.game.service;

import com.game.entity.GameInfo;
import com.game.mapper.GameInfoMapper;
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

    public GameInfo showGameInfo(int id){
        return gameInfoMapper.getGameinfoById(id);
    }



}
