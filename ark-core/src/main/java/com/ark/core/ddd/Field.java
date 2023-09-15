package com.ark.core.ddd;

/**
 * 实体属性，update-tracing.
 *
 * @param <T> 实际值
 */
public final class Field<T> {
  private boolean changed = false;
  private T value;

  private Field(T value) {
    this.value = value;
  }

  /**
   * 赋值.
   */
  public void setValue(T value) {
    if (!equalsValue(value)) {
      this.changed = true;
    }
    this.value = value;
  }

  public boolean isChanged() {
    return changed;
  }

  public T getValue() {
    return value;
  }

  /**
   * 值比较.
   */
  public boolean equalsValue(T value) {
    if (this.value == null && value == null) {
      return true;
    }
    if (this.value == null) {
      return false;
    }
    if (value == null) {
      return false;
    }
    return this.value.equals(value);
  }

  public static <T> Field<T> build(T value) {
    return new Field<T>(value);
  }
}