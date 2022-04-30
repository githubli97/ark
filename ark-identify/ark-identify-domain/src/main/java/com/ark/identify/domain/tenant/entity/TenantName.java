package com.ark.identify.domain.tenant.entity;

import com.ark.common.exception.api.Assert;
import lombok.Getter;

import java.util.Map;

@Getter
public class TenantName {
    private String name;

    public TenantName(String name) {
        Assert.isBlank(name, Map.of("name", "租户名称必须"));
        this.name = name;
    }
}
