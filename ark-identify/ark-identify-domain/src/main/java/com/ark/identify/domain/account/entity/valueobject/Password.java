package com.ark.identify.domain.account.entity.valueobject;

import com.ark.common.encrypt.EncryptUtils;
import com.ark.common.exception.api.Assert;
import com.ark.common.util.MapUtil;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Password {
    /**
     * 默认密码
     */
    public static final String DEFAULT_PASSWORD = "qwerasdf!";

    private String password;

    public Password(String password) {
        Assert.isBlank(password, MapUtil.simpleMap("password", "密码必填"));
        this.password = EncryptUtils.getSHA256Str(password);
    }
}
