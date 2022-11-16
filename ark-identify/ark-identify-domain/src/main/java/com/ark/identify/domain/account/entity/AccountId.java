package com.ark.identify.domain.account.entity;

import com.ark.common.exception.api.Assert;
import com.ark.common.util.MapUtil;
import lombok.Getter;

@Getter
public class AccountId {
    private Long id;

    public AccountId(Long id) {
        Assert.notNull(id, MapUtil.simpleMap("password", "密码必填"));

        this.id = id;
    }
}
