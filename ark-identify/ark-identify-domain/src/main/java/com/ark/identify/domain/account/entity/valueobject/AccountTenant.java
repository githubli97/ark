package com.ark.identify.domain.account.entity.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountTenant {
    private Long departmentId;
    private Long tenantId;
    private String tenantName;
    private String departmentName;
}
