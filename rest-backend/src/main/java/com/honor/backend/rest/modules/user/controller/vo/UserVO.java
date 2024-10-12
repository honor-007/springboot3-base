package com.honor.backend.rest.modules.user.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @Author honor
 * @Data 2024/7/3 11:27
 * @Version 1.0
 */

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
    private String id;

    private String code;
    private String account;
    private String password;
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
