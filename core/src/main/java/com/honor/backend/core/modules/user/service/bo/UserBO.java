package com.honor.backend.core.modules.user.service.bo;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * @Author honor
 * @Data 2024/7/3 9:34
 * @Version 1.0
 */
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBO {
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
    private List<String> roleIds;
    private List<String> deptIds;
    private List<String> postIds;
}
