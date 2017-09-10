package com.game.service;

import com.game.mapper.ArticleInfoMapper;
import com.game.model.ArticleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * Created by xiayifan on 2017/9/9.
 */
public class ArticleInfoService {
    @Autowired
    ArticleInfoMapper articleInfoMapper;

    public ArticleInfo getArticleDetailById(int id){
        return articleInfoMapper.getArticleInfoById(id);
    }

    public List<ArticleInfo> getArticleSearchInfo(int type, int time){
        List<ArticleInfo> articleInfos = articleInfoMapper.getArticleInfoBySearch(type, time);

        return articleInfos;
    }
}