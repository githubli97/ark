package com.ark.base.domain.base;

import com.ark.base.domain.trace.BaseTrace;

public abstract class ValueObject<T>  extends BaseTrace {
  public abstract boolean sameValueAs(T other);
}
