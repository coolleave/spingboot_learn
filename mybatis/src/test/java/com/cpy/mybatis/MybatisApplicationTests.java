package com.cpy.mybatis;

import com.cpy.mybatis.Mapper.EmpDelMapper;
import com.cpy.mybatis.Mapper.EmpInsertMapper;
import com.cpy.mybatis.Mapper.EmpSelectMapper;
import com.cpy.mybatis.Mapper.EmpUpdateMapper;
import com.cpy.mybatis.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class MybatisApplicationTests {
    @Autowired
    private EmpDelMapper empDelMapper;

    // 注入定义的mapper接口
    @Autowired
    private EmpInsertMapper empInsertMapper;

    @Autowired
    private EmpUpdateMapper empUpdateMapper;

    @Autowired
    private EmpSelectMapper empSelectMapper;


    @Test
    void contextLoads() {


        // 新增
        Emp emp = new Emp();
        emp.setUsername("tom");
        emp.setPassword("123456");
        emp.setName("汤姆");
        emp.setGender(1);
        emp.setImage("这是一个图片链接");
        emp.setJob(2);
        emp.setEntryDate(LocalDate.of(2004,7,30));
        emp.setDeptId(3);
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
//        empInsertMapper.EmpInsert(emp);

        // 删除
        //        System.out.println(delMapper.del_user(17));


        // 修改
//        Emp emp1 = new Emp();
//        emp1.setId(19);
//        emp1.setUsername("tom_update");
//        emp1.setUpdateTime(LocalDateTime.now());
//        empUpdateMapper.EmpUpdate(emp1);

//        // 按id查询
//        Emp emp_select =empSelectMapper.empSelect(19);
//        System.out.println(emp_select);

        // 按条件查询
        List<Emp> empList = empSelectMapper.empSelect_like("张");
        System.out.println(empList);
    }




}
