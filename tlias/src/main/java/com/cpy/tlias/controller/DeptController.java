package com.cpy.tlias.controller;

import com.cpy.tlias.polo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
    @GetMapping("/depts")
    public Result depts(){
        return Result.success();
    }
}
