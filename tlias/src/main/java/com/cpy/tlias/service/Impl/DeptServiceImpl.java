package com.cpy.tlias.service.Impl;

import com.cpy.tlias.mapper.DeptMapper;
import com.cpy.tlias.mapper.EmpMapper;
import com.cpy.tlias.polo.Dept;
import com.cpy.tlias.service.DeptService;
import jdk.jfr.StackTrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptMapper deptMapper;

    @Autowired
    EmpMapper empMapper;

    @Override
    // 查询部门列表实现方法
    public List<Dept> deptlist() {
        return deptMapper.deptlist();
    }

    // 根据id查询部门信息
    public Dept deptId(Integer id){
        return deptMapper.deptId(id);
    }


    /*
       删除部门方法实现
     */
    @Transactional  // 事务回滚注解，当这个函数出错时，整个函数就像没发生过一样。
    public void deptDel(Integer id) {
        deptMapper.depDel(id);  // 删除部门
//        int i = 1/0; // 模拟事务出错
        empMapper.delByDeptId(id);


        

    }

    /**
     * 新增部门方法实现
     *
     * @param dept 实体对象
     */
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
    public void deptUpd(Dept dept) {
        // 将修改部门的时间更新
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.deptUpd(dept);
    }
}
