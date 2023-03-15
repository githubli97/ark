package com.ark.domain.phone;

import com.ark.common.exception.api.Assert;
import com.ark.common.util.MapUtil;
import lombok.Getter;

import java.util.Map;
import java.util.regex.Pattern;

@Getter
public class ChinaPhone {
    private static final Pattern REGEX = Pattern.compile("^1[0-9]{10}$");
    private String phoneNumber;

    public ChinaPhone(String phoneNumber) {
        Assert.isBlank(phoneNumber, MapUtil.simpleMap("phoneNumber", "手机号不能为空"));
        Assert.matcherPattern(phoneNumber, REGEX, MapUtil.simpleMap("phoneNumber", "手机号不合法"));
        this.phoneNumber = phoneNumber;
    }
}
