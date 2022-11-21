package com.ark.identify.domain.department.service;

import com.ark.identify.domain.department.entity.Department;
import com.ark.identify.domain.department.entity.valueobject.DeptartmentTenant;

public interface DepartmentDomainService {

    /**
     * 创建根部门
     */
    Department createTenantRootDepartment(DeptartmentTenant convertThis);
}
