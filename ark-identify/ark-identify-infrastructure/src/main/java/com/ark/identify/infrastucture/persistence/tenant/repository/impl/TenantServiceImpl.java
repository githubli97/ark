package com.ark.identify.infrastucture.persistence.tenant.repository.impl;

import com.ark.base.convertor.Convertor;
import com.ark.base.service.ArkServiceImpl;
import com.ark.identify.domain.tenant.entity.Tenant;
import com.ark.identify.infrastucture.persistence.tenant.mapper.TenantMapper;
import com.ark.identify.infrastucture.persistence.tenant.model.TenantPO;
import com.ark.identify.infrastucture.persistence.tenant.repository.ITenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Tenant store(Tenant entiy) {
        TenantPO tenantPO = convertor.DOToPO(entiy);
        this.save(tenantPO);
        return entiy.setTenantId(tenantPO.getId());
    }
}
