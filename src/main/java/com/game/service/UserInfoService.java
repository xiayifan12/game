package com.game.service;

import com.game.mapper.UserInfoMapper;
import com.game.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xiayifan on 2017/9/14.
 */
@Service
public class UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;

    public int verifyUser(String user,String password){
        if(userInfoMapper.getUserInfoByName(user)==null)
        {
            return 0;
        }
        else if(userInfoMapper.getUserInfoByNameAndPwd(user,password)==null)
        {
            return 0;
        }
        else return 1;
    }

    public int verifyUser(String user){
        if(userInfoMapper.getUserInfoByName(user)==null)
        {
            return 1;
        }
        else return 0;
    }

    public int verifyUserAndEmail(String user,String email){
        if(userInfoMapper.getUserInfoByEmailAndUser(user,email)==null) return 0;
        else return 1;
    }

    public UserInfo getUserByName(String user){
        return userInfoMapper.getUserInfoByName(user);
    }

    public void addUser(String user,String password,String email,int pri){
        userInfoMapper.addUserInfo(user,password,pri,email);
    }

    public void updatePsw(String email,String password){
        userInfoMapper.modifyPasswd(email, password);
    }

}
