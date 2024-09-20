package com.cpy.tlias.service;

import com.cpy.tlias.polo.PageBean;


/**
 * EmpService接口
 */
public interface EmpService {
    // 分页查询方法
    PageBean empList(Integer page, Integer pageSize);
}
