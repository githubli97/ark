package com.ark.identify.domain.department.service.impl;

import com.ark.identify.domain.department.repository.DepartmentRepository;
import com.ark.identify.domain.department.service.DepartmentDomainService;
import com.ark.identify.domain.department.entity.Department;
import com.ark.identify.domain.department.entity.valueobject.DeptartmentTenant;
import com.ark.identify.domain.department.service.DepartmentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentDomainServiceImpl implements DepartmentDomainService {
    @Autowired
    private DepartmentRepository repository;

    @Override
    public Department createTenantRootDepartment(DeptartmentTenant convertThis) {
        Department rootDepartment = DepartmentFactory.getTenantRootDepartment(convertThis);
        repository.store(rootDepartment);
        return rootDepartment;
    }
}
