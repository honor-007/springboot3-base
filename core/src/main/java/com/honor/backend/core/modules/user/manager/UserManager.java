package com.honor.backend.core.modules.user.manager;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.honor.backend.core.modules.user.dao.criteria.UserCriteria;
import com.honor.backend.core.modules.user.dao.entity.User;
import com.honor.backend.core.modules.user.dao.impl.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author honor
 * @Data 2024/7/2 17:02
 * @Version 1.0
 */

@CacheConfig(cacheNames = {"UserManager"})
@RequiredArgsConstructor
@Service
public class UserManager {
    private final UserDAO userDAO;

    public IPage<User> page(UserCriteria criteria) {
        return userDAO.page(criteria);
    }

    public List<User> list(UserCriteria criteria) {
        return userDAO.list(criteria);
    }

    @CacheEvict(allEntries = true)
    public void save(User user) {
        userDAO.save(user);
    }

    @CacheEvict(allEntries = true)
    public void updateById(User user) {
        userDAO.updateById(user);
    }

    @CacheEvict(allEntries = true)
    public void deleteBatch(List<String> ids) {
        userDAO.removeBatchByIds(ids);
    }

    @Cacheable
    public User queryById(String id) {
        return userDAO.getById(id);
    }
}
