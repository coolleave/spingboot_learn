package com.cpy.tlias.exception;

import com.cpy.tlias.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice  // 此注解等于@RestControllerAdvice=@ControllerAdvice + @ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)  // 捕获所有的异常
    public Result ex(Exception ex){
        ex.printStackTrace();
        return Result.error("操作失败，请联系管理员");
    }
}
