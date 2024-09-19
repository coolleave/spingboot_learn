package com.cpy.tlias.controller;

import com.cpy.tlias.polo.Dept;
import com.cpy.tlias.polo.Result;
import com.cpy.tlias.service.DeptService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/depts")  // 将depts路径下的所有子路径整个到一个类上
public class DeptController {
    // 注入dept服务
    @Autowired
    DeptService deptService;
    @GetMapping
    public Result deptsList(){
        log.info("查询全部数据");
        // 获取部门列表
        List<Dept> list = deptService.deptlist();
        // 将结果返回，并且把list填进去
        return Result.success(list);
    }

    /**
     * 删除部门
     * @param id 删除部门的id
     */
    @DeleteMapping("/{id}")
    public Result deptsDel(@PathVariable Integer id){
        log.info("删除部门，id为"+id);
        deptService.deptDel(id);
        return Result.success();
    }

    /**
     * 新增部门
     */
    @PostMapping
    // 用@RequestBody 把接收到的json参数转化为实体对象
    public Result deptAdd(@RequestBody Dept dept){
        log.info("新增了部门"+dept);
        deptService.deptAdd(dept);
        return Result.success();
    }

    @PutMapping
    public Result deptUpdate(@RequestBody Dept dept){
        log.info("修改了部门"+dept);
        deptService.deptUpd(dept);
        return Result.success();
    }

}
