package com.ark.identify.infrastucture.persistence.role.repository.impl;

import com.ark.base.convertor.Convertor;
import com.ark.base.domain.trace.OperatorId;
import com.ark.identify.domain.role.entity.Role;
import com.ark.identify.infrastucture.persistence.role.model.RolePO;
import com.ark.identify.infrastucture.persistence.role.mapper.RoleMapper;
import com.ark.identify.infrastucture.persistence.role.repository.IRoleService;
import com.ark.base.service.ArkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author lihang
 * @since 2022-05-11
 */
@Service
public class RoleServiceImpl extends ArkServiceImpl<RoleMapper, RolePO> implements IRoleService {

    @Autowired
    private Convertor<Role, RolePO> convertor;

    @Override
    public void doStore(Role baseTrace) {
        RolePO rolePO = convertor.DOToPO(baseTrace);
        save(rolePO);
    }

    @Override
    public OperatorId getOperatorId() {
        return new OperatorId("0");
    }

    @Override
    public boolean isBaseTrace() {
        return true;
    }

    @Override
    public boolean isInsert(Role trace) {
        return true;
    }
}
