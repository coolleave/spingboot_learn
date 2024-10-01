package com.cpy.tlias.service;
import com.cpy.tlias.pojo.Dept;
import java.util.List;



public interface DeptService {
    // 查询部门列表接口方法
     List<Dept> deptlist();

     // 根据id查询部门信息
    Dept deptId(Integer id);

    /*
    删除部门方法实现
     */
     void deptDel(Integer id);

    /**
     * 添加部门接口
     * @param dept 实体对象
     */
    void deptAdd(Dept dept);

    /**
     * 修改部门接口
     * @param dept 实体对象
     */
    void deptUpd(Dept dept);


}

