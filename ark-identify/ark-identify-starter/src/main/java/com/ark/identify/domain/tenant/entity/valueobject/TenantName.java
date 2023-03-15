package com.ark.identify.domain.tenant.entity.valueobject;

import com.ark.common.exception.api.Assert;
import com.ark.common.util.MapUtil;
import lombok.Getter;

@Getter
public class TenantName {
    private String name;

    public TenantName(String name) {
        Assert.isBlank(name, MapUtil.simpleMap("name", "租户名称必须"));
        Assert.inLengthRange(name, 50, MapUtil.simpleMap("name", "租户名称长度需要小于50"));
        this.name = name;
    }
}
