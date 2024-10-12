package com.honor.infrastructure.conf.satoekn;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import com.honor.infrastructure.common.actor.ActorInterceptor;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author honor
 * @Data 2024/7/4 11:15
 * @Version 1.0
 * 路由拦截配置
 */
@Configuration
@AllArgsConstructor
public class SaTokenInterceptorConfigure implements WebMvcConfigurer {

    private final ActorInterceptor actorInterceptor;

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedHeaders("*")
//                .allowedMethods("*")
//                .maxAge(1800)
//                .allowedOrigins("*");
//    }


    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> knife4jUrls = new ArrayList<>();
        knife4jUrls.add("/favicon.ico");
        knife4jUrls.add("/error");
        knife4jUrls.add("/swagger-resources/**");
        knife4jUrls.add("/webjars/**");
        knife4jUrls.add("/v3/**");
        knife4jUrls.add("/v2/**");
        knife4jUrls.add("/doc.html");
        knife4jUrls.add("**/swagger-ui.html");
        knife4jUrls.add("/swagger-ui.html/**");
        knife4jUrls.add("/sso/**");
        knife4jUrls.add("/isLogin");
        knife4jUrls.add("/getSsoAuthUrl");
        knife4jUrls.add("/doLoginByTicket");
        knife4jUrls.add("/getSsoLoginTicket");
        knife4jUrls.add("/getSsoLogin");
        knife4jUrls.add("/sso/userinfo");

        List<String> userUrls = List.of("/api/backend/user/users/**", "/api/backend/account/sign-in/**");


        // 注册 Sa-Token 拦截器，校验规则为 StpUtil.checkLogin() 登录校验。
        registry.addInterceptor(new SaInterceptor(handle -> {
                    SaRouter
                            .match("/**")    // 拦截的 path 列表，可以写多个 */
                            .notMatch(knife4jUrls)
                            .notMatch(userUrls)
                            .check(r -> {
                                StpUtil.checkLogin();
                            });
                }))
                .addPathPatterns("/**");

        registry.addInterceptor(actorInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(userUrls);
    }

}
