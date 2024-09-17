package com.cpy.mybatis.pojo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data  // 使用@Data注解来自动生成java中的方法，toString()、equals()、hashCode()、以及 getter 和 setter 方法。
public class Emp {
    private int id;
    private String username;
    private String password;
    private String name;
    private int gender;
    private String image;
    private int job;
    private LocalDate entryDate;
    private int deptId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
