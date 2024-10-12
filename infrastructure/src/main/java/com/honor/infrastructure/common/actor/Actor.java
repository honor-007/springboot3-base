package com.honor.infrastructure.common.actor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author honor
 * @Data 2024/7/3 10:11
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Actor {
    private String id;
    private String code;
    private String account;
    private String name;
    private String realName;
    private String avatar;
    private String email;
    private String phone;
    private String birthday;
    private String sex;
    private String roleId;
    private String deptId;
    private String postId;
}
