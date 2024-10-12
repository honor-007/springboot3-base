package com.honor.backend.core.modules.user.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.honor.infrastructure.common.mybatisplus.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * @Author honor
 * @Data 2024/7/2 11:14
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "u_user", autoResultMap = true)
public class User extends BaseEntity {

    @TableId(type = IdType.ASSIGN_UUID)
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

    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> roleIds;
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> deptIds;
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> postIds;


}
