package com.ark.identify.domain.tenant.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TenantStatus {
    DISABLE(0, "禁用，封存"),
    Enable(1, "启用");

    private Integer code;
    private String name;
}
