package com.cpy.tlias.mapper;

import com.cpy.tlias.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
//
//    // 查询记录总数
//    @Select("select count(*) from emp;")
//    long empCount();
//
//    /**
//     * page 页码
//     * pageSize 页码容量
//     *
//     */
//    @Select("select * from emp limit #{start},#{pageSize}")
//    List<Emp> empList(Integer start ,Integer pageSize);

    // 使用PageHelper 对以上代码进行实现

//    @Select("select * from emp")
    List<Emp> empList(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    // 批量删除员工
    void empDel(List<Integer> ids);

    // 增加员工
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime}) ")
    void empAdd(Emp emp);

    @Select("select * from  emp where id = #{id}")
    Emp empQuery(Integer id);

    void empUpdate(Emp emp);

    @Select("select * from  emp where username=#{username} and password=#{password}")
    Emp login(Emp emp);

    @Delete("delete  from emp where dept_id = #{id}")
    void delByDeptId(Integer id);
}
