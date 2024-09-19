package com.cpy.tlias.service;

import com.cpy.tlias.mapper.DeptMapper;
import com.cpy.tlias.polo.Dept;
import com.cpy.tlias.service.Impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptService implements DeptServiceImpl {
    @Autowired
    DeptMapper deptMapper;
    @Override
    // 查询部门列表实现方法
    public  List<Dept> deptlist() {
        return deptMapper.deptlist();
    }

    /*
       删除部门方法实现
     */
    public void deptDel(Integer id){
       deptMapper.depDel(id);
    }

    /**
     * 新增部门方法实现
     * @param dept 实体对象
     */
    public  void deptAdd(Dept dept){
        // 补充新增部门的创建时间和更新时间
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.deptAdd(dept);
    }

    /**
     * 修改部门方法实现
     * @param dept 实体对象
     */
    public  void deptUpd(Dept dept){
        // 将修改部门的时间更新
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.deptUpd(dept);
    }
}
