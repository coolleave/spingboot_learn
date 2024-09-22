package com.cpy.tlias.controller;

import com.cpy.tlias.polo.PageBean;
import com.cpy.tlias.polo.Result;
import com.cpy.tlias.service.Impl.EmpServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
                          @RequestParam(defaultValue = "10") Integer pageSize,
                          String name,
                          Short gender,
                          @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate begin,
                          @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate end

                          ){
        PageBean pageBean = empService.empList(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }

    /**
     * 批量删除员工
     * @param ids 删除员工id集合
     *
     */
    @DeleteMapping("/{ids}")
    public Result empDel(@PathVariable List<Integer> ids){
        log.info("批量删除操作ids:{}",ids);
        empService.empDel(ids);
        return Result.success();
    }
}
