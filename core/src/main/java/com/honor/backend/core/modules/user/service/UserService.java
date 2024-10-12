package com.honor.backend.core.modules.user.service;

import cn.dev33.satoken.secure.BCrypt;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.honor.backend.core.modules.user.dao.criteria.UserCriteria;
import com.honor.backend.core.modules.user.dao.entity.User;
import com.honor.backend.core.modules.user.manager.UserManager;
import com.honor.backend.core.modules.user.service.bo.UserBO;
import com.honor.backend.core.modules.user.support.UserConstants;
import com.honor.backend.core.modules.user.support.UserConvertMapper;
import com.honor.infrastructure.common.exception.MSException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author honor
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserManager userManager;

    public IPage<UserBO> page(UserCriteria criteria) {
        IPage<User> page = userManager.page(criteria);
        return page.convert(UserConvertMapper.INSTANCE::from);
    }

    @Transactional
    public void save(UserBO userBO) {
        List<User> userList = userManager.list(UserCriteria.builder().account(userBO.getAccount()).build());
        if(!CollectionUtils.isEmpty(userList)){
            throw new MSException("用户名已存在");
        }
        User entity = initNewUserInstance(userBO);
        userManager.save(entity);
    }

    private User initNewUserInstance(UserBO userBO) {
        User entity = UserConvertMapper.INSTANCE.from(userBO);
        if (StringUtils.isBlank(entity.getPassword())) {
            entity.setPassword(UserConstants.DEFAULT_PASSWORD);
        }
        entity.setPassword(BCrypt.hashpw(entity.getPassword(), BCrypt.gensalt()));
        return entity;
    }

    @Transactional
    public void updateById(UserBO userBO) {
        User entity = UserConvertMapper.INSTANCE.from(userBO);
        if (StringUtils.isNotBlank(entity.getPassword())) {
            entity.setPassword(BCrypt.hashpw(entity.getPassword(), BCrypt.gensalt()));
        } else {
            entity.setPassword(null);
        }
        userManager.updateById(entity);
    }

    public UserBO getById(String id) {
        User user = userManager.queryById(id);
        return UserConvertMapper.INSTANCE.from(dataMasking(user));
    }

    //
//    @Transactional
//    public void removeById(List<String> ids) {
//        userManager.removeById(ids);
//    }

    public UserBO signByAccount(String account, String password) {
        UserCriteria criteria = UserCriteria.builder()
                .account(account)
                .build();
        List<User> users = userManager.list(criteria);
        if (CollectionUtils.isEmpty(users)) {
            return null;
        }

        User userSnap = users.get(0);
        if (!passwordCheck(password, userSnap)) {
            return null;
        }
        return UserConvertMapper.INSTANCE.from(dataMasking(userSnap));
    }

    private <T extends User> boolean passwordCheck(String password, T user) {
        return (!Objects.isNull(user)) && BCrypt.checkpw(password, user.getPassword());
    }

    private <T extends User> T dataMasking(T user) {
        if (Objects.nonNull(user)) {
            user.setPassword(null);
        }
        return user;
    }

    //
//    public void changeUserEnableStatus(String id, boolean enable) {
//        User user = userManager.getById(id);
//        if (Objects.isNull(user)) {
//            throw new BusinessException("USER_NOT_EXIST_ERROR");
//        }
//
//        if (Objects.equals(user.getEnable(), enable)) {
//            return;
//        }
//
//        user.setEnable(enable);
//        userManager.updateById(user);
//    }
//
    public void resetPassword(String id) {
        User user = userManager.queryById(id);
        if (Objects.isNull(user)) {
            throw new MSException("USER_NOT_EXIST_ERROR");
        }

        user.setPassword(BCrypt.hashpw(UserConstants.DEFAULT_PASSWORD, BCrypt.gensalt()));
        userManager.updateById(user);
    }

//    @Transactional
//    public void saveBatch(List<UserBO> users) {
//        for (UserBO user : users) {
//            save(user);
//        }
//    }
//
//    public UserBO getActor(String actorId) {
//        return getById(actorId);
//    }

}
