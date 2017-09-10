package com.game.service;

import com.game.mapper.ContentMapper;
import com.game.model.ContentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiayifan on 2017/9/9.
 */
@Service
public class ContentInfoService {
    @Autowired
    ContentMapper contentMapper;

    public List<ContentInfo> getContentDetailByType(int type){
        return contentMapper.getContentByType(type);
    }



}
