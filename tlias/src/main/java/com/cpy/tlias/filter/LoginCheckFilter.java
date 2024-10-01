package com.cpy.tlias.filter;

import com.alibaba.fastjson2.JSONObject;
import com.cpy.tlias.pojo.Result;
import com.cpy.tlias.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        // 1.获取url
        String url = req.getRequestURL().toString();
        log.info("url:{}", url);


        // 2.判断url地址中是否有login，如果有则放行。
        if(url.contains("login")){
            log.info("登录操作，放行！");
            filterChain.doFilter(req,res);
            return;
        }

        // 3.不含有，则提取jwt令牌
        String jwt = req.getHeader("token");
        log.info("jwt令牌：{}" ,jwt);
        // 4.判断jwt令牌是否为空,未登录
        if(!StringUtils.hasLength(jwt)){
            log.info("未登录");
            // 定义未登录对象
            Result error = Result.error("NOT_LOGIN");
            // 将对象转换为json格式
            String notLogin = JSONObject.toJSONString(error);
            // 将结果返回
            res.getWriter().write(notLogin);
            return;
        }
        // 如果令牌不为空，则解析令牌是否正确。
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            log.info("令牌不正确");
            // 定义未登录对象
            Result error = Result.error("NOT_LOGIN");
            // 将对象转换为json格式
            String notLogin = JSONObject.toJSONString(error);
            // 将结果返回
            res.getWriter().write(notLogin);
            return;

        }
        // 条件符合，放行
        log.info("放行");
        filterChain.doFilter(req,res);
    }
}
