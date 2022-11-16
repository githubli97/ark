package com.ark.identify.domain.account.entity.password;

import com.ark.common.encrypt.EncryptUtils;
import com.ark.common.exception.api.Assert;
import com.ark.common.util.MapUtil;
import lombok.Getter;

import java.util.Map;

public class Password {
    private String password;

    public Password(String password) {
        Assert.isBlank(password, MapUtil.simpleMap("password", "密码必填"));
        this.password = password;
    }

    public String getPassword() {
        return EncryptUtils.getSHA256Str(password);
    }
}
