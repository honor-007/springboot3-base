package com.jscoe.infrastructure.common.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author honor
 * @Data 2024/6/26 9:48
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse implements Serializable {
    private static final long serialVersionUID = 4985231996772888595L;
    private String code;
    private String message;

}
