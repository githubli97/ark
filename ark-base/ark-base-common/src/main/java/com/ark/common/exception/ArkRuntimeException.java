package com.ark.common.exception;

public class ArkRuntimeException extends RuntimeException {

    public ArkRuntimeException() {
    }

    public ArkRuntimeException(String message) {
        super(message);
    }
}
