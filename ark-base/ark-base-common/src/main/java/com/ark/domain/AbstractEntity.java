package com.ark.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public abstract class AbstractEntity {
    protected Long id;
    protected Long creator;
    protected Long modifier;
    protected LocalDateTime createdTime;
    protected LocalDateTime modifiedTime;
    protected Long version;
}
