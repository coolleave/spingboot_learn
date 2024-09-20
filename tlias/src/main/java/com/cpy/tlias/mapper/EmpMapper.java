package com.cpy.tlias.mapper;

import com.cpy.tlias.polo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface EmpMapper {

    // 查询记录总数
    @Select("select count(*) from emp;")
    long empCount();

    /**
     * page 页码
     * pageSize 页码容量
     *
     */
    @Select("select * from emp limit #{start},#{pageSize}")
    List<Emp> empList(Integer start ,Integer pageSize);

}
