package com.ark.identify.domain.department.entity;

import com.ark.domain.base.ArkEntity;
import com.ark.identify.domain.department.entity.valueobject.DepartmentName;
import com.ark.identify.domain.department.entity.valueobject.DeptartmentTenant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department extends ArkEntity<Department> {
    public static final long TENANT_ROOT_DEPARTMENT_ID = 1;


    private Long departmentId;
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
    private DeptartmentTenant tenant;
}
