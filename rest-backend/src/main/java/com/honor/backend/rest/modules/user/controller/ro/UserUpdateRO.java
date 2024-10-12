package com.honor.backend.rest.modules.user.controller.ro;

import java.util.List;

/**
 * @Author honor
 * @Data 2024/7/3 16:06
 * @Version 1.0
 */
public class UserUpdateRO {
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
