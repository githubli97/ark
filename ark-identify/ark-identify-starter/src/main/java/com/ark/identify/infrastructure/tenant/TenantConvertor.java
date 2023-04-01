package com.ark.identify.infrastructure.tenant;

import com.ark.identify.domain.tenant.Tenant;
import com.ark.infrastructure.base.Convertor;
import org.springframework.stereotype.Component;

/**
 * 租户实体向持久化对象实体转换.
 */
@Component
public class TenantConvertor implements Convertor<Tenant, TenantPo> {

  @Override
  public TenantPo getPersistentObjInstance() {
    return new TenantPo();
  }

  @Override
  public TenantPo persistentObjToDomainObj(TenantPo persistentObj, Tenant domainObj) {
    persistentObj.setName(domainObj.getName());
    return persistentObj;
  }
}
