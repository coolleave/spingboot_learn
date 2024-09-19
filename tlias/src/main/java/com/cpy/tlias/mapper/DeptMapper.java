package com.cpy.tlias.mapper;

import com.cpy.tlias.polo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public class DeptMapper {
    @Select("select * from dept ")
    public List<Dept> deptlist() {
        return null;
    }
}
