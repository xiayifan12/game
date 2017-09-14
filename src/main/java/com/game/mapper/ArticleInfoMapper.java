package com.game.mapper;

import com.game.model.ArticleInfo;
import org.apache.ibatis.annotations.*;
//import org.apache.ibatis.annotations.Result;
//import org.apache.ibatis.annotations.Results;
import com.game.util.SqlCreator;

import java.util.Date;
import java.util.List;

@Mapper
public interface ArticleInfoMapper {

//    @Results({
//            @Result(property = "enName", column = "enname")
//    })
    @Insert("insert into articleinfo(name, content,author_id,game_id) values(#{name}, #{content},  #{authorId},#{gameId})")
    boolean addArticle(@Param("name") String name,@Param("content") String content,@Param("authorId") int authorId,@Param("gameId")int gameId);

    @Delete("delete from articleinfo where id = #{id}")
    boolean deleteArticle(@Param("id")int id);

    @Select("SELECT * FROM articleinfo where id = #{id}")
    @Results({
            @Result(property = "authorId",column = "author_id")
    })
    ArticleInfo getArticleInfoById(int id);

    @Select("SELECT * FROM articleinfo where game_id = #{gameId}")
    List<ArticleInfo> getArticleInfoByGame(int gameId);

    @Select("SELECT * FROM articleinfo where id = #{id}")
    String getAuthorNameById(int id);

    @Select("select * from articleinfo where author_id = #{authorId}")
    List<ArticleInfo> getArticleInfoByAuthorId(int authorId);

    @Select("Select * from articleinfo where c_date = #{cTime}")
    List<ArticleInfo> getArticleInfoBycTime(Date cTime);

    @Select("Select * from articleinfo where m_date = #{mTime}")
    List<ArticleInfo> getArticleInfomTime(Date mTime);

    @Select("Select * from articleinfo where name like #{title}")
    List<ArticleInfo> getArticleInfomFromTitle(@Param("title") String title);

    @Update("update articleinfo set content = #{content} where id = #{id}")
    boolean updateArticleInfoById(@Param("content") String content,@Param("id") int id);

    @SelectProvider(type = SqlCreator.class ,method = "CreateSearchSql")
    List<ArticleInfo> getArticleInfoBySearch(int type, int time);

    @Select("SELECT count(*) from articleinfo")
    Integer getCountAricleInfo();

    @Select("SELECT * from articleinfo limit #{rnum},#{num}")
    List<ArticleInfo> getArticleInfoRandom(@Param("rnum") int rnum,@Param("num") int num);
}




















