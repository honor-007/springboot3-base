package com.honor.infrastructure.conf.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author honor
 */
@Configuration
@EnableCaching
public class CacheConfiguration {
    @Value("${sa-token.timeout}")
    private long timeout;

    @Bean
    public Cache<String, Object> caffeineCache() {
        return Caffeine.newBuilder()
                // 设置最后一次写入或访问后经过固定时间过期
                .expireAfterWrite(timeout, TimeUnit.SECONDS)
                // 初始的缓存空间大小
                .initialCapacity(1000)
                // 缓存的最大条数
                .maximumSize(5000)
                .build();
    }
}
