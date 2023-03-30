package com.ark.domain;


import com.ark.common.util.Constants;
import com.ark.domain.helper.SnowflakeIdGeneratorHelper;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractEntityFactory<E extends AbstractEntity> {

    @Autowired
    protected SnowflakeIdGeneratorHelper snowflakeIdGeneratorHelper;

    protected E createAbstractEntity() {
        E entity = getInstance();
        entity.id = snowflakeIdGeneratorHelper.nextId();
        entity.creator = 0L;
        entity.modifier = 0L;
        entity.createdTime = LocalDateTime.now();
        entity.modifiedTime = LocalDateTime.now();
        entity.version = Constants.ZERO;
        return entity;
    }

    protected abstract E getInstance();
}
