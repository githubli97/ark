package com.ark.identify.infrastucture.persistence.department.repository.impl;

import com.ark.base.convertor.Convertor;
import com.ark.base.domain.trace.OperatorId;
import com.ark.identify.domain.department.Department;
import com.ark.identify.domain.department.DepartmentFactory;
import com.ark.identify.domain.department.DepartmentId;
import com.ark.identify.infrastucture.persistence.department.model.DepartmentPO;
import com.ark.identify.infrastucture.persistence.department.mapper.DepartmentMapper;
import com.ark.identify.infrastucture.persistence.department.repository.IDepartmentService;
import com.ark.base.service.ArkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author lihang
 * @since 2022-05-15
 */
@Service
public class DepartmentServiceImpl extends ArkServiceImpl<DepartmentMapper, DepartmentPO> implements IDepartmentService {
    @Autowired
    private Convertor<Department, DepartmentPO> convertor;

    @Override
    public void doStore(Department baseTrace) {
        DepartmentPO departmentPO = convertor.DOToPO(baseTrace);
        saveOrUpdate(departmentPO);
        baseTrace.setDepartmentId(new DepartmentId(departmentPO.getDepartmentId()));
    }

    @Override
    public OperatorId getOperatorId() {
        return new OperatorId("1");
    }

    @Override
    public boolean isBaseTrace() {
        return true;
    }

    @Override
    public boolean isInsert(Department trace) {
        return Objects.nonNull(trace.getDepartmentId()) && trace.getDepartmentId().getDepartmentId().equals(DepartmentFactory.TENANT_ROOT_DEPARTMENT_ID) ;
    }
}
