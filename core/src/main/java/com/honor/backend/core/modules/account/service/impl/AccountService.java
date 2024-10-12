package com.honor.backend.core.modules.account.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.honor.backend.core.modules.account.service.ro.AccountSignInRO;
import com.honor.backend.core.modules.user.support.UserConvertMapper;
import com.honor.backend.core.modules.user.service.UserService;
import com.honor.backend.core.modules.user.service.bo.UserBO;
import com.honor.infrastructure.common.actor.UserCacheProvider;
import com.honor.infrastructure.common.exception.MSException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author honor
 */

@Service
@RequiredArgsConstructor
public class AccountService {
    private final UserService userService;
    private final UserCacheProvider userCacheProvider;

    public String accountSignIn(AccountSignInRO accountSign) {
        UserBO user = userService.signByAccount(accountSign.getAccount(), accountSign.getPassword());
        if (Objects.isNull(user)) {
            throw new MSException("ACCOUNT_OR_PASSWORD_ERROR");
        }
        StpUtil.login(user.getId());
        userCacheProvider.putCache(user.getId(), UserConvertMapper.INSTANCE.userCnvToActor(user));
        return StpUtil.getTokenValue();
    }

    public Boolean singOut(){
        userCacheProvider.evictCache(StpUtil.getLoginIdAsString());
        StpUtil.logout();
        return true;
    }
}
