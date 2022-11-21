package com.ark.common.dto;

import com.ark.common.enumerate.ResponseCodeEnum;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
public class Response<T> implements Serializable {
    private T data;
    private Boolean isSuccess;
    private Integer errCode;
    private String msg;

    public static final Response ok() {
        return Response.builder()
                .isSuccess(true)
                .errCode(ResponseCodeEnum.OK.getErrCode())
                .msg(ResponseCodeEnum.OK.getMsg())
                .build();
    }

    public static final <T> Response ok(T data) {
        return Response.builder()
                .data(data)
                .isSuccess(true)
                .errCode(ResponseCodeEnum.OK.getErrCode())
                .msg(ResponseCodeEnum.OK.getMsg())
                .build();
    }

    public static final Response error(ResponseCodeEnum responseCodeEnum) {
        return Response.builder()
                .isSuccess(false)
                .errCode(responseCodeEnum.getErrCode())
                .msg(responseCodeEnum.getMsg())
                .build();
    }

    public static final <T> Response<T> error(ResponseCodeEnum responseCodeEnum, T data) {
        return Response.<T>builder()
                .isSuccess(false)
                .data(data)
                .errCode(responseCodeEnum.getErrCode())
                .msg(responseCodeEnum.getMsg())
                .build();
    }
}
