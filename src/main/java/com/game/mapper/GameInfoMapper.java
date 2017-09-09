package com.game.mapper;

//  Created by xiayifan on 2017/9/8.

import com.game.model.GameInfo;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface GameInfoMapper {


    @Results({
        @Result(property = "describe",column = "describe")
    })

    @Insert("insert into gameinfo(name, enname, platform, version, connection, describe, copyright, type, website, image, time) values" +
            "(#{name}, #{enname}, #{platform}, #{version}, #{connection}, #{describe}, #{copyright}, #{type}, #{website}, #{image}, #{time})")
    boolean insertGameInfo(String name, String enname, String platform, String version, int connection, String describe, String copyright, int type, String website, String image, Date time);

    @Delete("delete gameinfo where id = #{id}")
    boolean deleteGameInfoById(int id);

    @Select("SELECT * FROM gameinfo where id = #{id}")
    GameInfo getGameInfoById(int id);

    @Select("SELECT * FROM gameinfo where id = #{name}")
    GameInfo getGameInfoByName(int name);

    @Select("SELECT * FROM gameinfo where type = #{type}")
    List<GameInfo> getGameInfoByType(int type);

    @Update("update gameinfo set version = #{version} where id = #{id}")
    boolean updateGameInfoById(String version, int id);
}
