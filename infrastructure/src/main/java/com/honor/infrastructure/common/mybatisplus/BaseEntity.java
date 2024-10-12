package com.honor.infrastructure.common.mybatisplus;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

/**
 * @Author honor
 * @Data 2024/7/2 11:25
 * @Version 1.0
 */
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
    @TableField(fill = FieldFill.INSERT)
    private Instant isDeleted;
    @TableField(fill = FieldFill.INSERT)
    private Instant createdAt;
    @TableField(fill = FieldFill.INSERT)
    private String createdBy;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Instant updatedAt;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updatedBy;
}
