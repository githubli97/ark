package com.ark.identify.infrastructure.tenant;

import com.ark.identify.domain.tenant.Tenant;
import com.ark.infrastructure.base.Convertor;
import org.springframework.stereotype.Component;

@Component
public class TenantConvertor implements Convertor<Tenant, TenantPO> {

  @Override
  public TenantPO getPersistentObjInstance() {
    return new TenantPO();
  }

  @Override
  public TenantPO persistentObjToDomainObj(TenantPO persistentObj, Tenant domainObj) {
    persistentObj.setName(domainObj.getName());
    return persistentObj;
  }

  @Override
  public Tenant POToDO(TenantPO PO) {
    return null;
  }
}
