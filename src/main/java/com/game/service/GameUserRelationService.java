package com.game.service;

import com.game.mapper.GameInfoMapper;
import com.game.mapper.GameUserRelationMapper;
import com.game.model.GameInfo;
import com.game.model.LikeInfo;
import com.game.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiayifan on 2017/9/12.
 */
@Service
public class GameUserRelationService {

    @Autowired
    GameUserRelationMapper gameUserRelationMapper;
    @Autowired
    GameInfoMapper gameInfoMapper;

    public int CancelOrAddRelation(int gameId, int userId){

        LikeInfo likeInfo = gameUserRelationMapper.getRelationByGameIdAndUserId(userId,gameId);
        if(likeInfo==null){
            gameUserRelationMapper.insertRelation(gameId,userId);
            return 1;
        }
        else{
            gameUserRelationMapper.deleteRelation(gameId, userId);
            return 0;
        }
    }

    public List<GameInfo> getGamesRelation2User(int userId){
       return gameInfoMapper.getGameInfoRelation2User(userId);
    }


}
