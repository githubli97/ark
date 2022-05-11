package com.ark.identify.infrastucture.persistence.tenant.repository.impl;

import com.ark.base.convertor.Convertor;
import com.ark.base.domain.trace.OperatorId;
import com.ark.identify.domain.tenant.entity.Tenant;
import com.ark.identify.domain.tenant.entity.TenantId;
import com.ark.identify.infrastucture.persistence.tenant.model.TenantPO;
import com.ark.identify.infrastucture.persistence.tenant.mapper.TenantMapper;
import com.ark.identify.infrastucture.persistence.tenant.repository.ITenantService;
import com.ark.base.service.ArkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lihang
 * @since 2022-05-10
 */
@Service
public class TenantServiceImpl extends ArkServiceImpl<TenantMapper, TenantPO> implements ITenantService {
    @Autowired
    private Convertor<Tenant, TenantPO> convertor;

    @Override
    public void doStore(Tenant baseTrace) {
        TenantPO tenantPO = convertor.DOToPO(baseTrace);
        saveOrUpdate(tenantPO);

        Long id = tenantPO.getId();
        baseTrace.setTenantId(new TenantId(id));
    }

    @Override
    public OperatorId getOperatorId() {
        //todo
        return new OperatorId("1");
    }

    @Override
    public boolean isBaseTrace() {
        return true;
    }

    @Override
    public boolean isInsert(Tenant trace) {
        return Objects.isNull(trace.getTenantId());
    }
}
