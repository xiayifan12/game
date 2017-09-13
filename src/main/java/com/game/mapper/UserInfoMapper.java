package com.game.mapper;

import com.game.model.UserInfo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserInfoMapper {

    @Insert("insert into userinfo(name, passwd, priviledge, email) values(#{name}, #{password},#{priviledge}, #{email})")
    boolean addUserInfo(@Param("name") String name,@Param("password") String passwd,@Param("priviledge") int priviledge,@Param("email") String email);

    @Delete("delete userinfo where id = #{id}")
    boolean deleteUserInfoById(int id);

    @Delete("delete userinfo where name = #{name}")
    boolean deleteUserInfoByName(String name);

    @Select("SELECT * FROM userinfo WHERE id = #{id}")
    UserInfo getUserInfoById(int id);

    @Select("select * from userinfo where name = #{name}")
    UserInfo getUserInfoByName(@Param("name")String name);

    @Select("select * from userinfo where email = #{email}")
    UserInfo getUserInfoByEmail(String email);

    @Select("select * from userinfo where email = #{email} and name = #{user}")
    UserInfo getUserInfoByEmailAndUser(@Param("user")String user,@Param("email")String email);

    @Select("select * from userinfo where name = #{name} and passwd=#{passwd}")
    UserInfo getUserInfoByNameAndPwd(@Param("name")String name,@Param("passwd")String passwd);

    @Update("update userinfo set passwd = #{passwd} where email = #{email}")
    boolean modifyPasswd(@Param("email") String email,@Param("passwd") String passwd);
}





















