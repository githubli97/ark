package com.ark.identify.domain.tenant;

import com.ark.domain.AbstractEntityFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 租户实体工厂.
 */
@Service
@AllArgsConstructor
public class TenantFactory extends AbstractEntityFactory<Tenant> {

  /**
   * 创建租户,默认初始化审计相关字段.
   *
   * @param name 租户名称
   * @return 租户实体
   */
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
