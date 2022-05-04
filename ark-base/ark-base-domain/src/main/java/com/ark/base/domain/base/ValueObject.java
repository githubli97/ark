package com.ark.base.domain.base;

import java.io.Serializable;

public interface ValueObject<T> extends Serializable {
  boolean sameValueAs(T other);
}
