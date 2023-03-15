package com.ark.identify.infrastucture.persistence.department.repository.impl;

import com.ark.infrastructure.convertor.Convertor;
import com.ark.infrastructure.service.ArkServiceImpl;
import com.ark.identify.domain.department.entity.Department;
import com.ark.identify.infrastucture.persistence.department.repository.IDepartmentService;
import com.ark.identify.infrastucture.persistence.department.mapper.DepartmentMapper;
import com.ark.identify.infrastucture.persistence.department.model.DepartmentPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Department store(Department entiy) {
        DepartmentPO po = convertor.DOToPO(entiy);
        this.save(po);
        return entiy.setDepartmentId(po.getId());
    }
}
