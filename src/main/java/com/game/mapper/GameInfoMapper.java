package com.game.mapper;

//  Created by xiayifan on 2017/9/8.

import com.game.model.GameInfo;
import com.game.util.SqlCreator;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper

public interface GameInfoMapper {



    @Insert("insert into gameinfo(name,enname,platform,game_version,g_connection,g_describe,copyright,type_id,image,game_date,banner) values" +
            "(#{name},#{enName},#{platform},#{version},#{connection},#{describe},#{copyright},#{type},#{imageName},#{date},#{bannerName})")
    boolean insertGameInfo(@Param("name") String name,@Param("enName") String enName,@Param("platform") String platform,@Param("version") String version,@Param("connection") int connection,@Param("describe") String describe,@Param("copyright") String copyright,@Param("type") int type,@Param("imageName") String imageName,@Param("date") Date date,@Param("bannerName") String bannerName);

    @Delete("delete from gameinfo where id = #{id}")
    boolean deleteGameInfoById(int id);

    @Select("SELECT * FROM gameinfo where id = #{id}")
    @Results({
            @Result(property = "enName",column = "enname"),
            @Result(property = "version",column = "game_version"),
            @Result(property = "type", column = "type_id"),
            @Result(property = "time",column = "game_date"),
            @Result(property = "connection" ,column = "g_connection"),
            @Result(property = "describe" , column = "g_describe")
    })
    GameInfo getGameInfoById(int id);

    @Select("SELECT * FROM gameinfo where name = #{name}")
    @Results({
            @Result(property = "enName",column = "enname"),
            @Result(property = "version",column = "game_version"),
            @Result(property = "type", column = "type_id"),
            @Result(property = "time",column = "game_date"),
            @Result(property = "connection" ,column = "g_connection"),
            @Result(property = "describe" , column = "g_describe")
    })
    GameInfo getGameInfoByName(String name);

    @Select("SELECT * FROM gameinfo where type = #{type}")
    List<GameInfo> getGameInfoByType(int type);

    @Update("update gameinfo set game_version = #{version} where id = #{id}")
    boolean updateGameInfoById(@Param("version") String version,@Param("id")int id);

    @Select("SELECT * from gameinfo limit #{rnum},#{num}")
    List<GameInfo> getGameInfoRandom(@Param("rnum") int rnum,@Param("num") int num);

    @SelectProvider(type = SqlCreator.class ,method = "CreateSearchSql")
    @Results({
            @Result(property = "enName",column = "enname"),
            @Result(property = "version",column = "game_version"),
            @Result(property = "type", column = "type_id"),
            @Result(property = "time",column = "game_date"),
            @Result(property = "connection" ,column = "g_connection"),
            @Result(property = "describe" , column = "g_describe")
    })
    List<GameInfo> getGameInfoBySearch(int type,int platform,int net,int time,int page);

    @Select("SELECT count(*) from gameinfo")
    Integer getCountGameInfo();

    @Select("SELECT * FROM gameinfo where id IN (SELECT game_id from game_user_relation where user_id = #{userId})")
    @Results({
            @Result(property = "enName",column = "enname"),
            @Result(property = "version",column = "game_version"),
            @Result(property = "type", column = "type_id"),
            @Result(property = "time",column = "game_date"),
            @Result(property = "connection" ,column = "g_connection"),
            @Result(property = "describe" , column = "g_describe")
    })
    List<GameInfo> getGameInfoRelation2User(@Param("userId") int userId);


}
