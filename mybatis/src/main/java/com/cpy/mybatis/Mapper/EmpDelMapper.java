package com.cpy.mybatis.Mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpDelMapper {
    @Delete("delete from emp where id=#{id}")
    public int del_user(Integer id);
}
