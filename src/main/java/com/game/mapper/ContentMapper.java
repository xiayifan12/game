package com.game.mapper;

import com.game.model.ContentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by xiayifan on 2017/9/9.
 */
@Mapper
public interface ContentMapper {
    @Select("SELECT * from content where type = #{type} ORDER by queue")
    public List<ContentInfo> getContentByType(int type);
}
