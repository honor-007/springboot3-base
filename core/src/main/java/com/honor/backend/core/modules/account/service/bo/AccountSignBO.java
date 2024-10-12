package com.honor.backend.core.modules.account.service.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author honor
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountSignBO {
    private String account;
    private String password;
}
