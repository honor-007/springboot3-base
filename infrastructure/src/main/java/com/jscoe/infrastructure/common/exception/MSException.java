package com.jscoe.infrastructure.common.exception;

import lombok.Data;

/**
 * @Author honor
 * @Data 2024/6/26 9:41
 * @Version 1.0
 */
@Data
public class MSException extends RuntimeException {
    private static final long serialVersionUID = -5195341167826040681L;
    private String code;
    private String message;


    public MSException() {
        super("");
    }

    public MSException(String message) {
        super(message);
        this.message = message;
    }

    public MSException(String message, Throwable cause) {
        super(message, cause);
        this.code = null;
        this.message = message;
    }

    public MSException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public MSException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public MSException(Throwable cause, String code, String message) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public MSException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.message = message;
    }

    public MSException(MSError error) {
        super(error.getMessage());
        this.code = error.getCode();
        this.message = error.getMessage();
    }
}
