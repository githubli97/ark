package com.ark.identify.infrastucture.persistence.department.convertor;

import com.ark.base.convertor.Convertor;
import com.ark.identify.domain.account.entity.PhoneAccount;
import com.ark.identify.domain.department.Department;
import com.ark.identify.domain.department.repository.DepartmentRepository;
import com.ark.identify.infrastucture.persistence.account.model.AccountPO;
import com.ark.identify.infrastucture.persistence.department.model.DepartmentPO;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentPO DOToPO(Department DO) {
        DepartmentPO departmentPO = new DepartmentPO().setCreater(Long.parseLong(DO.getCreater().getOperatorId()))
                .setModifier(Long.parseLong(DO.getModifier().getOperatorId()))
                .setCreateTime(DO.getCreateTime())
                .setModifyTime(DO.getModifyTime())
                .setTenantId(DO.getTenantId().getTenantId())
                .setDepartmentId(DO.getDepartmentId().getDepartmentId())
                .setDepartmentName(DO.getDepartmentName().getDepartmentName())
                .setDepartmentIndex(departmentRepository.getDepartmentIndex(DO));

        if (Objects.nonNull(DO.getParent())) {
            departmentPO.setDepartmentParentId(DO.getParent().getDepartmentId().getDepartmentId());
        }
        return departmentPO;
    }
}
