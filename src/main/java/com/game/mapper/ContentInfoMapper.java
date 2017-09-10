package com.game.mapper;

/**
 * Created by 大清自有国情在此 on 2017/9/10.
 */

import com.game.model.ContentInfo;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface ContentInfoMapper {

//    @Results({
//            @Result(property = "describe",column = "describe")
//    })

//    @Insert("insert into gameinfo(name, enname, platform, version, connection, describe, copyright, type, website, image, time,banner) values" +
//            "(#{name}, #{enname}, #{platform}, #{version}, #{connection}, #{describe}, #{copyright}, #{type}, #{website}, #{image}, #{time},#{banner)")
//    boolean insertGameInfo(String name, String enname, String platform, String version, int connection, String describe, String copyright, int type, String website, String image, Date time,String banner);
//
//    @Delete("delete gameinfo where id = #{id}")
//    boolean deleteGameInfoById(int id);

    @Select("SELECT * FROM content where type = #{type}")
    ContentInfo getContentInfoByType(int type);

//    @Select("SELECT * FROM gameinfo where id = #{name}")
//    ContentInfo getGameInfoByName(int name);
//
//    @Select("SELECT * FROM gameinfo where type = #{type}")
//    List<ContentInfo> getGameInfoByType(int type);
//
//    @Update("update gameinfo set version = #{version} where id = #{id}")
//    boolean updateGameInfoById(String version, int id);
}