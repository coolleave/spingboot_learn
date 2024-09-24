package com.cpy.tlias.controller;

import com.cpy.tlias.polo.Emp;
import com.cpy.tlias.polo.PageBean;
import com.cpy.tlias.polo.Result;
import com.cpy.tlias.service.Impl.EmpServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Insert;
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

    /**
     * 增加员工
     * @param emp 员工参数json格式
     */
    @PostMapping
    public  Result empAdd(@RequestBody Emp emp){
        log.info("增加员工:{}",emp);
        empService.empAdd(emp);
        return Result.success();
    }


    /**
     * 查询单个员工
     * @param id 员工id
     */
    @GetMapping("/{id}")
    public Result empQuery(@PathVariable Integer id){
        log.info("查询员工信息，id为{}",id);
        Emp emp = empService.empQuery(id);
        return  Result.success(emp);
    }
}
