package com.cpy.mybatis.Mapper;

import com.cpy.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmpUpdateMapper {
    @Update("update  emp set  username=#{username},update_time=#{updateTime} where id=#{id} ;")
    public void EmpUpdate(Emp emp);
}
