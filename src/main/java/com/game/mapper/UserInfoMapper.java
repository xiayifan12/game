package com.game.mapper;

import com.game.model.UserInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserInfoMapper {

    @Insert("insert into userinfo(name, passwd, priviledge, email) values(#{name}, #{password},#{priviledge}, #{email}")
    boolean addUserInfo(String name, String passwd, int priviledge, String email);

    @Delete("delete userinfo where id = #{id}")
    boolean deleteUserInfoById(int id);

    @Delete("delete userinfo where name = #{name}")
    boolean deleteUserInfoByName(String name);

    @Select("SELECT * FROM userinfo WHERE id = #{id}")
    UserInfo getUserInfoById(int id);

    @Select("select * from userinfo where name = #{name}")
    UserInfo getUserInfoByName(String name);

    @Select("select * from userinfo where email = #{email}")
    UserInfo getUserInfoByEmail(String email);

    @Update("update userinfo set passwd = #{passwd} where email = #{email}")
    boolean modifyPasswd(String passwd, String email);
}





















