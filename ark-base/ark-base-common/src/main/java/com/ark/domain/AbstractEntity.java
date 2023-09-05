package com.ark.domain;

import java.time.LocalDateTime;
import lombok.Getter;

/**
 * 抽象领域实体父类, 可审计, 有版本, 所有实体必须继承.
 */
@Getter
public abstract class AbstractEntity {

  protected Long id;
  protected Long creator;
  protected Long modifier;
  protected LocalDateTime createdTime;
  protected LocalDateTime modifiedTime;
  protected Long version;
}