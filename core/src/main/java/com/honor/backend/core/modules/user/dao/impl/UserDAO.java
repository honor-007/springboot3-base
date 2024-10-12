package com.honor.backend.core.modules.user.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.honor.backend.core.modules.user.dao.criteria.UserCriteria;
import com.honor.backend.core.modules.user.dao.entity.User;
import com.honor.backend.core.modules.user.dao.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author honor
 * @Data 2024/7/2 17:00
 * @Version 1.0
 */

@Repository
public class UserDAO extends ServiceImpl<UserMapper, User> {

    private LambdaQueryWrapper<User> buildQueryWrapper(UserCriteria criteria) {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(StringUtils.isNotBlank(criteria.getAccount()), User::getAccount, criteria.getAccount());
        return queryWrapper;
    }

    public IPage<User> page(UserCriteria criteria) {
        return baseMapper.selectPage(new Page<User>(criteria.getPageNum(), criteria.getPageSize()), buildQueryWrapper(criteria));
    }

    public List<User> list (UserCriteria criteria) {
        return baseMapper.selectList(buildQueryWrapper(criteria));
    }
}
