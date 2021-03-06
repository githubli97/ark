package com.ark.identify.domain.role.entity;

import com.ark.common.exception.api.Assert;
import lombok.Getter;

import java.util.Map;

@Getter
public class RoleName {
    private String roleName;

    public RoleName(String roleName) {
        Assert.inLengthRange(roleName, 20, Map.of("roleName", "角色名称在0-20之间"));

    }
}
