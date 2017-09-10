package com.game.service;


/**
 * Created by 大清自有国情在此 on 2017/9/10.
 */

import com.game.mapper.ContentInfoMapper;
import com.game.mapper.ContentMapper;
import com.game.model.ContentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentInfoService {

    @Autowired
    ContentInfoMapper contentInfoMapper;

    public ContentInfo getContentDetailByType(int type){

        return contentInfoMapper.getContentInfoByType(type);
    }
}

