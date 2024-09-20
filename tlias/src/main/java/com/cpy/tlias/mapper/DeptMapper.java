package com.cpy.tlias.mapper;

import com.cpy.tlias.polo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    // 查询所有的部门
    @Select("select * from dept ")
    List<Dept> deptlist();

    /**
     * 根据部门id查询部门信息
     * @param id 部门id
     * @return 返回dept对象
     */
    @Select("select * from dept where id=#{id}")
    Dept deptId(Integer id);
    /*
    删除新增部门
     */
    @Delete("delete  from dept where id=#{id}")
     void depDel(Integer id);

    /**
     * 新增部门
     * @param dept 新增部门实体对象
     */
    @Insert("insert into dept(name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void deptAdd(Dept dept);

    /**
     * 修改部门名称
     * @param dept 修改部门对象
     */
    @Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id}")
    void deptUpd(Dept dept);


}
