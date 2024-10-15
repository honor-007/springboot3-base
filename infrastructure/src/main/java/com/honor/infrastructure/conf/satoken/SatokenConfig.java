package com.honor.infrastructure.conf.satoken;

import cn.dev33.satoken.strategy.SaStrategy;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.UUID;

/**
 * @Author honor
 * @Data 2024/7/11 16:45
 * @Version 1.0
 */
@Configuration
@AllArgsConstructor
public class SatokenConfig {
    private final Environment environment;
    /**
     * 重写 Sa-Token 框架内部token生成算法策略
     */
    @PostConstruct
    public void rewriteSaStrategy() {
        // 重写 Token 生成策略
        SaStrategy.instance.createToken = (loginId, loginType) -> {
            String profiles = environment.getProperty("spring.profiles.active");
            if("prod".equals(profiles)||"local".equals(profiles)){
                //生产环境生成固定token 方便测试
                return "550e8400-e29b-41d4-a716-446655440000";
            }else{
                return UUID.randomUUID().toString();   // 随机60位长度字符串
            }
        };
    }
}
