package com.cpy.mybatis.Mapper;

import com.cpy.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;


@Mapper
public interface EmpInsertMapper {
    // 返回主键的值
    @Options(keyProperty = "id",useGeneratedKeys = true)
    @Insert("insert into emp( username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time)"
            +
            "values (#{username},#{password},#{name},#{gender},#{image},#{job},#{entryDate},#{deptId},#{createTime},#{updateTime});")
    public void EmpInsert(Emp emp);
}
