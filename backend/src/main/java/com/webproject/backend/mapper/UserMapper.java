package com.webproject.backend.mapper;

import com.webproject.backend.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    List<User> getUser(@Param("username")String username);

    @Insert("insert into user (username,password) values(#{username},#{password})")
    void insertUser(@Param("username")String username,@Param("password")String password);
}
