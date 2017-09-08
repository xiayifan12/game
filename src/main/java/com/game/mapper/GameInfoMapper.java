package com.game.mapper;

import com.game.entity.GameInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by xiayifan on 2017/9/8.
 */
@Mapper
public interface GameInfoMapper {

    @Results({
            @Result(property = "enName",column = "en_name")
    })
    @Select("SELECT * FROM gameinfo where id = #{id}")
    GameInfo getGameinfoById(int id);



}
