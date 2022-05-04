package com.ark.common.exception;

import com.ark.common.enumerate.ResponseCodeEnum;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class ArkResponseRuntimeException extends ArkRuntimeException {
    protected abstract ResponseCodeEnum getResponseCodeEnum();
}
