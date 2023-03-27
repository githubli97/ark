package com.ark.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public abstract class AbstractEntity {
    protected Long id;
    protected Long creator;
    protected Long modifier;
    protected LocalDateTime createdDateTime;
    protected LocalDateTime modifiedDateTime;
}
