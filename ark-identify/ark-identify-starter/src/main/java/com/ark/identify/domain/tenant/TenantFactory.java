package com.ark.identify.domain.tenant;

import com.ark.domain.AbstractEntityFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TenantFactory extends AbstractEntityFactory<Tenant> {

  public Tenant createTenant(String name) {
    Tenant tenant = createAbstractEntity();

    tenant.setName(name);
    return tenant;
  }

  @Override
  protected Tenant getInstance() {
    return new Tenant();
  }
}
