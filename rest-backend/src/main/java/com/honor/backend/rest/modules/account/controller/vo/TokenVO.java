package com.honor.backend.rest.modules.account.controller.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author honor
 */
@Data
@Builder
public class TokenVO {
    private String token;
}
