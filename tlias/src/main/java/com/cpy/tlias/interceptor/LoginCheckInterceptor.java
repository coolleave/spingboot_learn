package com.cpy.tlias.interceptor;

import com.alibaba.fastjson2.JSONObject;
import com.cpy.tlias.pojo.Result;
import com.cpy.tlias.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor{

    @Override  // 目标资源执行前执行，true放行，false不放行。
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        // 1.获取url
        String url = req.getRequestURL().toString();
        log.info("url:{}", url);


        // 2.判断url地址中是否有login，如果有则放行。
        if(url.contains("login")){
            log.info("登录操作，放行！");

            return true;
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
            return false;
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
            return false;

        }
        // 条件符合，放行
        log.info("放行");

        return true;
    }


    @Override // 目标资源执行后执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...");
    }


    @Override // 视图渲染完执行，最后执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
