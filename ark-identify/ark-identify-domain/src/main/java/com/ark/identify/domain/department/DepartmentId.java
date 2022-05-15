package com.ark.identify.domain.department;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class DepartmentId {
    private Integer departmentId;

    public DepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
