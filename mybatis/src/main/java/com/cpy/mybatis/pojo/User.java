package com.cpy.mybatis.pojo;


import lombok.Data;

@Data
public class User {

    // 入门阶段，建议和数据库中的字段名称一样。

    private Integer id;
    private String name;
    private short age;
    private short gender;


}
