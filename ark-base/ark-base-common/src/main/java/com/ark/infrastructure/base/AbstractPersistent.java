package com.ark.infrastructure.base;

import com.ark.domain.AbstractEntity;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
public abstract class AbstractPersistent<D extends AbstractEntity> {
    protected Long id;
    protected Long creator;
    protected Long modifier;
    protected LocalDateTime createdDateTime;
    protected LocalDateTime modifiedDateTime;
}
