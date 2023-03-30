package com.ark.infrastructure.base;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class AbstractPersistent {

    @Id
    protected Long id;
    @Column(name = "CREATOR")
    protected Long creator;
    @Column(name = "MODIFIER")
    protected Long modifier;
    @Column(name = "CREATED_TIME")
    protected LocalDateTime createdTime;
    @Column(name = "MODIFIED_TIME")
    protected LocalDateTime modifiedTime;
    @Column(name = "IS_DELETED")
    protected boolean isDeleted;
    @Column(name = "VERSION")
    protected Long version;
}
