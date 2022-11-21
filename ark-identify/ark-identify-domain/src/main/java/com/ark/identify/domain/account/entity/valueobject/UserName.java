package com.ark.identify.domain.account.entity.valueobject;

import com.ark.common.exception.api.Assert;
import com.ark.common.util.MapUtil;
import lombok.Getter;

@Getter
public class UserName {
    private String userName;

    public UserName(String userName) {
        Assert.isBlank(userName, MapUtil.simpleMap("userName", "用户名必填"));
        this.userName = userName;
    }
}
