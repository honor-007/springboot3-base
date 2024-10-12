package com.honor.backend.rest.modules.user.controller.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author honor
 * @Data 2024/7/3 13:25
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserQuery {
    private String id;

    private String code;
}
