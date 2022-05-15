package com.ark.identify.domain.department;

import com.ark.identify.domain.tenant.entity.TenantId;
import lombok.Getter;

@Getter
public class DepartmentFactory {
    public static final int TENANT_ROOT_DEPARTMENT_ID = 1;

   public static Department getTenantRootDepartment(TenantId tenantId, DepartmentName departmentName) {
       return new Department(departmentName, tenantId, new DepartmentId(TENANT_ROOT_DEPARTMENT_ID));
   }
}
