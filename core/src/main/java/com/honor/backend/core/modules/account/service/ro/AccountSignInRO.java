package com.honor.backend.core.modules.account.service.ro;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


/**
 * @author honor
 */
@Data
public class AccountSignInRO {
    @NotBlank(message="账号不可为空")
    private String account;
    @NotBlank(message="密码不可为空")
    private String password;
}
