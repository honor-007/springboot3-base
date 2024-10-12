package com.honor.infrastructure.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;

/**
 * @Author honor
 * @Data 2024/7/2 11:29
 * @Version 1.0
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "isDeleted", Boolean.class, false);
        this.strictInsertFill(metaObject, "createdAt", Instant.class, Instant.now());
        this.strictInsertFill(metaObject, "createdBy", String.class, "honor");
        this.strictInsertFill(metaObject, "updatedAt", Instant.class, Instant.now());
        this.strictInsertFill(metaObject, "updatedBy", String.class, "honor");
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updatedAt", Instant.class, Instant.now());
        this.strictInsertFill(metaObject, "updatedBy", String.class, "honor");
    }

}
