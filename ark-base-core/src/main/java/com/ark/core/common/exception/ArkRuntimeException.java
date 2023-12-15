package com.ark.core.common.exception;

/**
 * 封装项目级运行时异常.
 */
public class ArkRuntimeException extends RuntimeException {

  public ArkRuntimeException() {
  }

  public ArkRuntimeException(String message) {
    super(message);
  }
}
