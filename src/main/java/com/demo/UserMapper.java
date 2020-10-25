package com.demo;

import com.demo.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    //login
    User selectUser(@Param("account")String account);

    //register
    void insertUser(@Param("account")String account,@Param("password")String password);
    void insertInfo(@Param("account")String account,@Param("username")String username);

    //displayInfo
    User selectInfo(@Param("account")String account);

    //updateInfo
    void updateInfo(@Param("account")String account,@Param("username")String username,@Param("gender")String gender,@Param("city")String city);


    void deleteUser(@Param("account")String account);
    void deleteInfo(@Param("account")String account);
    void updateUser(@Param("account")String account,@Param("password")String password);



}
