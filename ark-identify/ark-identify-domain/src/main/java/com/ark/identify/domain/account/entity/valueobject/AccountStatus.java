package com.ark.identify.domain.account.entity.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountStatus {
    DISABLE(0, "禁用，封存"),
    Enable(1, "启用");

    private Integer code;
    private String name;
}
