package com.cpy.tlias.aop;

import com.alibaba.fastjson2.JSONObject;
import com.cpy.tlias.mapper.OperateLogMapper;
import com.cpy.tlias.pojo.OperateLog;
import com.cpy.tlias.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Arrays;



@Slf4j
@Component
@Aspect
public class LogAspect {
    // 注入网络请求注解，用于解析jwt令牌中的用户信息
    @Autowired
    HttpServletRequest request;

    @Autowired
    // 注入mapper对象
    OperateLogMapper operateLogMapper;



    // 使用注解方法带入切点表达式
    @Around("@annotation(com.cpy.tlias.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {

        // 方法执行前计时
        long start = System.currentTimeMillis();



        // 接下来就获取各项数据
        // 操作人id，通过解析jwt令牌获取
        String jwt = request.getHeader("token");
        // 解析jwt令牌，获取claim
        Claims claim = JwtUtils.parseJWT(jwt);
        Integer operatorId = (Integer) claim.get("id");
        // 操作时间
        LocalDateTime operateTime = LocalDateTime.now();
        // 操作类名
        String operateClass = joinPoint.getTarget().getClass().getName();
        // 操作方法名
        String operateFunction = joinPoint.getSignature().getName();
        // 操作方法参数
        Object[] operateArgs = joinPoint.getArgs();
        String methodArgs = Arrays.toString(operateArgs);
        // 操作方法返回值
        Object result = joinPoint.proceed();    // 执行原始方法
        String returnValue = JSONObject.toJSONString(result);  // 将对象转换为json格式
        // 操作耗时,单位为毫秒
        long end = System.currentTimeMillis();
        long time = end - start ;
        // 写入对象并调用方法。
        OperateLog operateLog = new OperateLog(null,operatorId,operateTime,operateClass,operateFunction,methodArgs,returnValue,time);
        operateLogMapper.insert(operateLog);
        log.info("新增一条操作记录：{}",operateLog);
        return result;
    }

}
