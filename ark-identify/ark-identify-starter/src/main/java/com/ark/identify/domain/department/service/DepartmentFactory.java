package com.ark.identify.domain.department.service;

import com.ark.identify.domain.department.entity.Department;
import com.ark.identify.domain.department.entity.valueobject.DepartmentName;
import com.ark.identify.domain.department.entity.valueobject.DeptartmentTenant;
import lombok.Getter;

@Getter
public class DepartmentFactory {

   public static Department getTenantRootDepartment(DeptartmentTenant tenant) {
       return new Department(Department.TENANT_ROOT_DEPARTMENT_ID, null, new DepartmentName(tenant.getTenantName()), tenant);
   }
}
