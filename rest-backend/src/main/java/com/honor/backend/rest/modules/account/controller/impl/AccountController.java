package com.honor.backend.rest.modules.account.controller.impl;

import com.honor.backend.core.modules.account.service.impl.AccountService;
import com.honor.backend.core.modules.account.service.ro.AccountSignInRO;
import com.honor.backend.rest.modules.account.controller.vo.TokenVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.honor.backend.rest.modules.account.support.AccountConstants.ACCOUNT_URI;

/**
 * @author honor
 */
@Tag(name = "账户")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = ACCOUNT_URI)
public class AccountController {
    //    private final ActorContext actorContext;
    private final AccountService accountService;

    @Operation(summary = "登录")
    @PostMapping(value = "sign-in")
    public TokenVO signIn(@Validated @RequestBody AccountSignInRO args) {
        String token = accountService.accountSignIn(args);
        return TokenVO.builder()
                .token(token)
                .build();
    }

    @Operation(summary = "登出")
    @PostMapping(value = "sign-out")
    public Boolean signOut() {
        return accountService.singOut();
    }
}
