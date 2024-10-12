package com.honor.infrastructure.common.actor;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author honor
 */
@Component
@RequiredArgsConstructor
public class UserCacheProvider {
    private static final String CACHE_NAME = "IngredientDetectionUserCache";

    private final CacheManager cacheManager;

    public void putCache(String key, Object value) {
        if (ObjectUtils.isEmpty(key)) {
            return;
        }
        Cache cache = cacheManager.getCache(CACHE_NAME);
        cache.put(key, value);
    }

    public Object getCache(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        Cache cache = cacheManager.getCache(CACHE_NAME);
        ValueWrapper valueWrapper = cache.get(key);

        return Objects.isNull(valueWrapper) ? null : valueWrapper.get();
    }

    public <T> T getCache(String key, Class<T> type) {
        if (StringUtils.isBlank(key)) {
            return null;
        }

        Cache cache = cacheManager.getCache(CACHE_NAME);

        return cache.get(key, type);
    }

    public void evictCache(String key) {
        if (StringUtils.isBlank(key)) {
            return;
        }

        Cache cache = cacheManager.getCache(CACHE_NAME);
        cache.evictIfPresent(key);
    }
}
