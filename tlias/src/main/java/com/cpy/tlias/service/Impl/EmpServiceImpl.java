package com.cpy.tlias.service.Impl;

import com.cpy.tlias.mapper.EmpMapper;
import com.cpy.tlias.polo.Emp;
import com.cpy.tlias.polo.PageBean;
import com.cpy.tlias.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Emp实现类 员工操作service实现类
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    /**
     *
     * @param page 页码
     * @param pageSize 页码容量
     * @return 返回PageBean对象给EmpController
     */
    public PageBean empList (Integer page, Integer pageSize) {
        // 调用empMapper.empCount()方法查询总数
        long total = empMapper.empCount();
        // 计算出起始索引  公式为页码-1 再乘页面容量
        Integer start = (page-1) * pageSize;
        // 调用empMapper.empList方法进行员工分页查询
        List<Emp> empList = empMapper.empList(start,pageSize);
        // 创建一个PageBean实例，并返回
        return new PageBean(total,empList);

    }
}
