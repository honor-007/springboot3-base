package com.honor.backend.core.modules.user.dao.criteria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author honor
 * @Data 2024/7/3 13:24
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCriteria {
    private String id;

    private String account;
    private String code;
    private Integer pageNum;
    private Integer pageSize;
}
