package com.cpy.tlias.service;

import com.cpy.tlias.polo.Emp;
import com.cpy.tlias.polo.PageBean;

import java.time.LocalDate;
import java.util.List;


/**
 * EmpService接口
 */
public interface EmpService {
    // 分页查询方法
    PageBean empList(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    // 批量删除员工
    void empDel(List<Integer> ids);

    // 增加员工
    void empAdd(Emp emp);
}
