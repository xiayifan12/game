package com.game.mapper;

import org.apache.ibatis.annotations.Select;

public interface LikeInfo {

    @Select("select user_id from favorite where game_id = #{gameId}")
    int getUserIdByGameId(int gameId);

    @Select("select game_id from favorite where user_id = #{userId}")
    int getGameIdByUserId(int userId);
}
