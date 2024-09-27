package com.cpy.tlias.controller;

import com.cpy.tlias.polo.Emp;
import com.cpy.tlias.polo.Result;
import com.cpy.tlias.service.EmpService;
import com.cpy.tlias.utils.JwtUtils;
import com.sun.net.httpserver.Authenticator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    EmpService empService;


    @PostMapping("/login")
    public Result Login(@RequestBody Emp emp){
        // 查询用户，返回员工对象。如果为空则用户名密码不正确。
        Emp e = empService.login(emp);
        if(e!=null){
            Map<String,Object> claims = new HashMap<>();
            claims.put("username",e.getUsername());
            claims.put("name",e.getName());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");

    }

}
