package com.cpy.tlias.controller;

import com.cpy.tlias.polo.PageBean;
import com.cpy.tlias.polo.Result;
import com.cpy.tlias.service.Impl.EmpServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    EmpServiceImpl empService;

    /**
     * 分页查询员工
     * @param page  页码，默认为 1
     * @param pageSize 页码容量，默认为 10
     * @return 返回类为 Result 调用 Result.success() 并传入pageBean类
     */
    @GetMapping
    public Result empList(@RequestParam(defaultValue = "1") Integer page,
                          @RequestParam(defaultValue = "10") Integer pageSize){
        PageBean pageBean = empService.empList(page,pageSize);
        return Result.success(pageBean);
    }


}
