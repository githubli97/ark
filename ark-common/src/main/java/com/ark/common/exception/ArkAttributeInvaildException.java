package com.ark.common.exception;

import com.ark.common.dto.Response;
import com.ark.common.enumerate.ResponseCodeEnum;
import lombok.Getter;

import java.util.Map;

/**
 * 属性不合法校验
 */
@Getter
public class ArkAttributeInvaildException extends ArkResponseRuntimeException {
    private final Response<Map<String, String>> response;

    public ArkAttributeInvaildException(Map<String, String> data) {
        this.response = Response.error(getResponseCodeEnum(), data);
    }

    protected ResponseCodeEnum getResponseCodeEnum() {
        return ResponseCodeEnum.ATTRIBUTE_INVAILD;
    }
}
