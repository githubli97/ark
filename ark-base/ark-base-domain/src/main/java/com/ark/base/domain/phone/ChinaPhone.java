package com.ark.base.domain.phone;

import com.ark.common.exception.api.Assert;
import lombok.Getter;

import java.util.Map;
import java.util.regex.Pattern;

@Getter
public class ChinaPhone {
    private static final Pattern REGEX = Pattern.compile("^1[0-9]{10}$");
    private String phoneNumber;

    public ChinaPhone(String phoneNumber) {
        Assert.isBlank(phoneNumber, Map.of("phoneNumber", "手机号不能为空"));
        Assert.matcherPattern(phoneNumber, REGEX, Map.of("phoneNumber", "手机号不合法"));
        this.phoneNumber = phoneNumber;
    }
}
