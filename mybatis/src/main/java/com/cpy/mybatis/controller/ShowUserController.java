package com.cpy.mybatis.controller;

import com.cpy.mybatis.Mapper.UserMapper;
import com.cpy.mybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShowUserController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/showUser")
    public List<User> showUser(){
        List<User> list = userMapper.showUser();
        list.forEach(user -> {
            System.out.println("~~~~~~~~~~~");
            System.out.println(user.getName());
        });
        return userMapper.showUser();
    }

}
