package com.cpy.tlias.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component  // 交给ioc容器管理
@Aspect      // 面向切面编程
@Slf4j
public class TimeAspect {
    // 第一个*是返回值，第二个*是任意类名，第三个*是任意方法名
    @Pointcut("execution(* com.cpy.tlias.service.*.*(..))")
    private void pt(){};  // 切入点表达式可以抽取，抽取后可以复用
    @Around("execution(* com.cpy.tlias.service.*.*(..))") // 切入点表达式
    public Object timeRecord(ProceedingJoinPoint joinPoint) throws Throwable {
        // 1.记录开始时间
        long startTime = System.currentTimeMillis();
        // 2.调用原始方法
        Object result = joinPoint.proceed();
        // 3.记录结束时间
        long endTime = System.currentTimeMillis();
        long time = endTime-startTime;
        log.info("消耗的时间为{}ms",time);
        return result;
    }
}
