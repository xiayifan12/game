package com.game.service;

import com.game.mapper.ArticleInfoMapper;
import com.game.model.ArticleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by xiayifan on 2017/9/9.
 */
@Service
public class ArticleInfoService {
    @Autowired
    ArticleInfoMapper articleInfoMapper;


    public ArticleInfo getArticleDetailById(int id){
        return articleInfoMapper.getArticleInfoById(id);
    }

//    public List<ArticleInfo> getArticleSearchInfo(int type, int time){
//        List<ArticleInfo> articleInfos = articleInfoMapper.getArticleInfoBySearch(type, time);
//
//        return articleInfos;
//    }

    public void addNewArticle(String title,String field,int gameId,int userId){

        articleInfoMapper.addArticle(title,field,userId,gameId);
    }

    public List<ArticleInfo> getArticleDetailByGame(int gameId){
        return articleInfoMapper.getArticleInfoByGame(gameId);
    }

    public List<ArticleInfo> getArticleDetailByTitle(String title){
        title = "%"+title+"%";
        return articleInfoMapper.getArticleInfomFromTitle(title);
    }

    public List<ArticleInfo> getArticleDetailRandom(int num){

        int rnum;
        Integer count = articleInfoMapper.getCountAricleInfo();
        if (count>2) rnum = new Random().nextInt(count-2);
        else rnum = 0;
        return articleInfoMapper.getArticleInfoRandom(rnum,num);

    }

    public void deleteArticleById(int articleId){
        articleInfoMapper.deleteArticle(articleId);
    }

    public void updateArticleById(int articleId,String content){
        articleInfoMapper.updateArticleInfoById(content,articleId);
    }





}
