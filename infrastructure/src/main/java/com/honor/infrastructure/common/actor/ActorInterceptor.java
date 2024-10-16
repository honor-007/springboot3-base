package com.honor.infrastructure.common.actor;

import cn.dev33.satoken.stp.StpUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Enumeration;


/**
 * @Author honor
 * @Data 2024/7/3 11:08
 * @Version 1.0
 */
@Component
@AllArgsConstructor
public class ActorInterceptor implements HandlerInterceptor {

    private final UserCacheProvider userCacheProvider;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String loginId = StpUtil.getLoginIdAsString();
        Actor actor = userCacheProvider.getCache(loginId,Actor.class);
        ActorInfoThreadHolder.addCurrentUser(actor);
        return true;
    }

    /**
     * 避免内存泄露
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ActorInfoThreadHolder.remove();
    }

}
