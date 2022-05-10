package com.ark.common.exception;

import com.ark.common.dto.Response;
import com.ark.common.enumerate.ResponseCodeEnum;
import lombok.Getter;

/**
 * 业务校验失败
 */
@Getter
public class ArkServiceException extends ArkResponseRuntimeException {
    private final Response<String> response;

    public ArkServiceException(String supplementary) {
        this.response = Response.error(getResponseCodeEnum(), supplementary);
    }

    @Override
    protected ResponseCodeEnum getResponseCodeEnum() {
        return ResponseCodeEnum.SERVICE_RULE_NO_ALLOWED;
    }
}
