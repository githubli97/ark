package com.ark.identify.domain.account.entity;

import com.ark.common.exception.api.Assert;
import lombok.Getter;

import java.util.Map;

@Getter
public class AccountId {
    private Long id;

    public AccountId(Long id) {
        Assert.notNull(id, Map.of("password", "密码必填"));

        this.id = id;
    }
}
