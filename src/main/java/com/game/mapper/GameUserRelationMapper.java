package com.game.mapper;

import com.game.model.LikeInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface GameUserRelationMapper {

    @Select("select user_id from game_user_relation where game_id = #{gameId}")
    List<Integer> getUserIdByGameId(int gameId);

    @Select("select game_id from game_user_relation where user_id = #{userId}")
    List<Integer> getGameIdByUserId(int userId);

    @Select("select * from game_user_relation where user_id = #{userId} and game_id = #{gameId}")
    @Results({
            @Result(property = "gameId",column = "game_id"),
            @Result(property = "userId",column = "user_id")
    })
    LikeInfo getRelationByGameIdAndUserId(@Param("userId") int userId ,@Param("gameId") int gameId);

    @Insert("Insert into game_user_relation(game_id,user_id) values(#{gameId},#{userId})")
    void  insertRelation(@Param("gameId") int gameId,@Param("userId") int userId);

    @Delete("delete from game_user_relation where user_id = #{userId} and game_id = #{gameId}")
    void  deleteRelation(@Param("gameId") int gameId,@Param("userId") int userId);




}
