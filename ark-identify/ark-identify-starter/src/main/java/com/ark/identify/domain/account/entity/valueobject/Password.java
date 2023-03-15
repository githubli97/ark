package com.ark.identify.domain.account.entity.valueobject;

import com.ark.common.exception.api.Assert;
import com.ark.common.util.MapUtil;
import com.ark.domain.helper.ArkApplicationContextAware;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@NoArgsConstructor
public class Password {
    /**
     * 默认密码
     */
    public static final String DEFAULT_PASSWORD = "qwerasdf!";

    private String password;

    public Password(String password) {
        PasswordEncoder passwordEncoder = ArkApplicationContextAware.applicationContext.getBean("passwordEncoder", PasswordEncoder.class);
        Assert.isBlank(password, MapUtil.simpleMap("password", "密码必填"));
        this.password = passwordEncoder.encode(password);
    }
}
