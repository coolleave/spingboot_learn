package com.cpy.tlias.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 用于切点表达式的注解
 */
@Retention(RetentionPolicy.RUNTIME) // 执行时间为运行时间
@Target(ElementType.METHOD)  // 注解的作用类型为方法
public @interface Log {
}
