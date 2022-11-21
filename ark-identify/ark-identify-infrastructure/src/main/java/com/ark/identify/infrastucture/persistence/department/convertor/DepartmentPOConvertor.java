package com.ark.identify.infrastucture.persistence.department.convertor;

import com.ark.base.convertor.Convertor;
import com.ark.identify.domain.department.entity.Department;
import com.ark.identify.infrastucture.persistence.department.model.DepartmentPO;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * <p>
 *
 * </p>
 *
 * @author lihang
 * @since 2022-05-09
 */
@Component
public class DepartmentPOConvertor implements Convertor<Department, DepartmentPO> {
    @Override
    public DepartmentPO DOToPO(Department DO) {
        DepartmentPO departmentPO = new DepartmentPO()
                .setTenantId(DO.getTenant().getTenantId())
                .setDepartmentId(DO.getDepartmentId())
                .setDepartmentName(DO.getDepartmentName().getDepartmentName());

        if (Objects.nonNull(DO.getParent())) {
            departmentPO.setDepartmentParentId(DO.getParent().getDepartmentId());
        }
        return departmentPO;
    }
}
