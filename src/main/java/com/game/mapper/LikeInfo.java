package com.game.mapper;

import org.apache.ibatis.annotations.Select;

public interface LikeInfo {

    @Select("select user_id from like where game_id = #{gameId}")
    int getUserIdByGameId(int gameId);

    @Select("select game_id from like where user_id = #{userId}")
    int getGameIdByUserId(int userId);
}
