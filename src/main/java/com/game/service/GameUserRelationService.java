package com.game.service;

import com.game.mapper.GameUserRelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xiayifan on 2017/9/12.
 */
@Service
public class GameUserRelationService {

    @Autowired
    GameUserRelationMapper gameUserRelationMapper;

    public int CancelOrAddRelation(int gameId, int userId){

        if(gameUserRelationMapper.getRelationByGameIdAndUserId(userId,gameId)==null){
            gameUserRelationMapper.insertRelation(gameId,userId);
            return 1;
        }
        else{
            gameUserRelationMapper.deleteRelation(gameId, userId);
            return 0;
        }

    }


}
