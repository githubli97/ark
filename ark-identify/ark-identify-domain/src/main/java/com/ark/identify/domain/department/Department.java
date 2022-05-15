package com.ark.identify.domain.department;

import com.ark.base.domain.base.ValueObject;
import com.ark.identify.domain.tenant.entity.TenantId;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Department extends ValueObject<Department> {
    private DepartmentId departmentId;
    /**
     * 父部门
     */
    private Department parent;
    /**
     * 部门名称
     */
    private DepartmentName departmentName;
    /**
     * 租户id
     */
    private TenantId tenantId;

    @Override
    public boolean sameValueAs(Department other) {
        return departmentId.equals(other.getDepartmentId()) && tenantId.equals(other.getTenantId());
    }

    Department(DepartmentName departmentName, TenantId tenantId) {
        this.departmentName = departmentName;
        this.tenantId = tenantId;
    }
    Department(DepartmentName departmentName, TenantId tenantId, DepartmentId departmentId) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.tenantId = tenantId;
    }

    public void setDepartmentId(DepartmentId departmentId) {
        this.departmentId = departmentId;
    }
}
