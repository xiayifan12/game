package com.game.mapper;

import com.game.model.ArticleInfo;
import org.apache.ibatis.annotations.*;
//import org.apache.ibatis.annotations.Result;
//import org.apache.ibatis.annotations.Results;

import java.util.Date;
import java.util.List;

@Mapper
public interface ArticleInfoMapper {

//    @Results({
//            @Result(property = "enName", column = "enname")
//    })
    @Insert("insert into article(name, content, c_date, m_date, author_id) values(#{name}, #{content}, #{cTime}, #{mTime}, #{authorId})")
    boolean addArticle(String name, String content, Date cTime, Date mTime, int authorId);

    @Delete("delete article where id = #{id}")
    boolean deleteArticle(int id);

    @Select("SELECT * FROM articleinfo where id = #{id}")
    ArticleInfo getArticleInfoById(int id);

    @Select("SELECT * FROM articleinfo where id = #{id}")
    String getAuthorNameById(int id);

    @Select("select * from articleinfo where author_id = #{authorId}")
    List<ArticleInfo> getArticleInfoByAuthorId(int authorId);

    @Select("Select * from articleinfo where c_date = #{cTime}")
    List<ArticleInfo> getArticleInfoBycTime(Date cTime);

    @Select("Select * from articleinfo where m_date = #{mTime}")
    List<ArticleInfo> getArticleInfomTime(Date mTime);

    @Update("update articleinfo set content = #{content} and m_date = #{mTime} where id = #{id}")
    boolean updateArticleInfoById(String content, int id, Date mTime);
}




















