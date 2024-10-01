package com.cpy.tlias.service.Impl;

import com.cpy.tlias.anno.Log;
import com.cpy.tlias.mapper.DeptLogMapper;
import com.cpy.tlias.mapper.DeptMapper;
import com.cpy.tlias.mapper.EmpMapper;
import com.cpy.tlias.pojo.Dept;
import com.cpy.tlias.pojo.DeptLog;
import com.cpy.tlias.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptMapper deptMapper;

    @Autowired
    EmpMapper empMapper;

    @Autowired
    DeptLogMapper deptLogMapper;

    @Override
    // 查询部门列表实现方法
    public List<Dept> deptlist() {
        return deptMapper.deptlist();
    }

    // 根据id查询部门信息
    public Dept deptId(Integer id) {
        return deptMapper.deptId(id);
    }


    /*
       删除部门方法实现
     */
    @Log  // 日志记录
    @Transactional  // 事务回滚注解，当这个函数出错时，整个函数就像没发生过一样。
    public void deptDel(Integer id) {
        try {
            deptMapper.depDel(id);  // 删除部门
//            int i = 1 / 0; // 模拟事务出错
            empMapper.delByDeptId(id);
        }
        finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了部门删除操作，id是" + id);
            deptLogMapper.insertLog(deptLog);
        }


    }

    /**
     * 新增部门方法实现
     *
     * @param dept 实体对象
     */
    @Log  // 日志记录
    public void deptAdd(Dept dept) {
        // 补充新增部门的创建时间和更新时间
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.deptAdd(dept);
    }

    /**
     * 修改部门方法实现
     *
     * @param dept 实体对象
     */
    @Log  // 日志记录
    public void deptUpd(Dept dept) {
        // 将修改部门的时间更新
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.deptUpd(dept);
    }
}
