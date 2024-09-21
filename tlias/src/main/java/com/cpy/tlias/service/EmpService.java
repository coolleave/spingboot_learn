package com.cpy.tlias.service;

import com.cpy.tlias.polo.PageBean;

import java.time.LocalDate;



/**
 * EmpService接口
 */
public interface EmpService {
    // 分页查询方法
    PageBean empList(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);
}
