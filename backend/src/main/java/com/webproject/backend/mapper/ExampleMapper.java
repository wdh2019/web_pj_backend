package com.webproject.backend.mapper;

import com.webproject.backend.entity.ExampleUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @decription
 * mybatis的dao接口层，只需要写接口，不需要实现
 * 第一行是sql语句，参数用 #{...}形式
 * 第二行返回类型ExampleUser用来接收数据库返回的内容，数据库字段名与实体类字段名应该一致，会自动注入
 * @Param用来传递基本类型参数和String
 * 也可不使用@Param，直接传递对象，但对象应该包括sql语句中的参数的字段，并且名称一致
 * 使用时，在service层自动注入mapper，调用mapper方法
 */
@Mapper
@Repository
public interface ExampleMapper {

    @Select("select * from user where username = #{username} and password = #{password}")
    ExampleUser getUser(@Param("username")String username, @Param("password")String password);

}
