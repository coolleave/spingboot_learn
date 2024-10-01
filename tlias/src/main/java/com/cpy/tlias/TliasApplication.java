package com.cpy.tlias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ServletComponentScan  // 拦截器启动注解
public class TliasApplication {

    public static void main(String[] args) {
        SpringApplication.run(TliasApplication.class, args);
    }

}
