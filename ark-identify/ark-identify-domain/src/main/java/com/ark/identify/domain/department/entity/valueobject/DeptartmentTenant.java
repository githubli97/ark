package com.ark.identify.domain.department.entity.valueobject;

import com.ark.identify.domain.tenant.entity.Tenant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeptartmentTenant {
    private Long tenantId;
    private String tenantName;

    public static DeptartmentTenant convertThis(Tenant tenant) {
        DeptartmentTenant deptartmentTenant = new DeptartmentTenant();
        deptartmentTenant.setTenantId(tenant.getTenantId())
                .setTenantName(tenant.getTenantName().getName());
        return deptartmentTenant;
    }
}
