package com.cpy.mybatis.Mapper;

import com.cpy.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpSelectMapper {

    // 按id查询
//    @Select("Select * from emp where id=#{id}")
//    public Emp empSelect(Integer id);

    // 按姓名条件查询
    // 占位字符解决方法1 使用$进行占位 不推荐
//    @Select("select * from emp where name like '%${name}%';")
//    public List<Emp> empSelect_like(String name);


    // 方法2 使用concat进行拼接  推荐
    @Select("select * from emp where name like concat('%',#{name},'%');")
    public List<Emp> empSelect_like(String name);


}
