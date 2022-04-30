package com.ark.identify.domain.account.entity.password;

import com.ark.common.exception.api.Assert;
import lombok.Getter;

import java.util.Map;

@Getter
public class Password {
    private String password;

    public Password(String password) {
        Assert.isBlank(password, Map.of("password", "密码必填"));
        this.password = password;
    }
}
