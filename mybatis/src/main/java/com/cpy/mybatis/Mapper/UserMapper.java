package com.cpy.mybatis.Mapper;

import com.cpy.mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;


// 使用mapper注解
@Mapper
public interface UserMapper {

    // 查询表user中所有的值
    @Select("select * from user")
    public List<User> showUser();
}
