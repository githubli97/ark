package com.ark.identify.domain.account.entity.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountStatus {
    DISABLE(0, "禁用，封存"),
    ENABLE(1, "启用");

    private Integer code;
    private String name;

    public static final AccountStatus getByCode(Integer code) {
        for (AccountStatus status : AccountStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        return null;
    }
}
