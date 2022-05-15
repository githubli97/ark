package com.ark.identify.domain.department.repository;

import com.ark.base.domain.trace.BaseTraceRepository;
import com.ark.identify.domain.department.Department;
import com.ark.identify.domain.role.entity.Role;

import java.util.Objects;

public interface DepartmentRepository extends BaseTraceRepository<Department> {
    /**
     * id分隔符
     */
    String ID_SPLIT_STRING = ",";
    /**
     * 部门id索引
     * pId,currentId
     */
    default String getDepartmentIndex(Department department) {
        if (department.getDepartmentId().getDepartmentId() == 1) {
            return "1";
        }
        return getDepartmentIndex(department.getParent()) + ID_SPLIT_STRING + department.getDepartmentId().getDepartmentId();
    }
}
