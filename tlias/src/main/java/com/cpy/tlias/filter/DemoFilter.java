package com.cpy.tlias.filter;

import com.github.pagehelper.BoundSqlInterceptor;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;


// filter拦截器优先级按照字母排序，a最大，z最小
@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    // 创建拦截器，只执行一次
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截到一个请求");
        // 放行，调用doFilter方法并传入请求和响应
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("放行了一个请求");

    }
    // 拦截过程
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);


    }
    // 销毁拦截，执行一次
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
