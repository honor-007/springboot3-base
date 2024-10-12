package com.honor.infrastructure.common.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author honor
 * @Data 2024/6/26 9:42
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MSError implements Serializable {
    private static final long serialVersionUID = -1926135926270553351L;
    private String code;
    private String message;

}
