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

    @Select("SELECT * FROM content where type = #{type}")
    ContentInfo getContentInfoByType(int type);


}