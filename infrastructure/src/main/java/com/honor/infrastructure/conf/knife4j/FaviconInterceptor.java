package com.honor.infrastructure.conf.knife4j;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class FaviconInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 修复NoResourceFoundException: No static resource favicon.ico
        if (!"GET".equalsIgnoreCase(request.getMethod()) || !request.getRequestURI().toString().equals("/favicon.ico")) {
            return true;
        }
        response.setStatus(HttpStatus.NO_CONTENT.value()); // 设置状态码为204 No Content
        return false;
    }
}
