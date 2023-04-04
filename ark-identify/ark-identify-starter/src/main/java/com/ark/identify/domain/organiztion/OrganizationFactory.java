package com.ark.identify.domain.organiztion;

import com.ark.domain.AbstractEntityFactory;
import com.ark.identify.domain.tenant.Tenant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 组织实体工厂.
 */
@Service
@AllArgsConstructor
public class OrganizationFactory extends AbstractEntityFactory<Organization> {

  /**
   * 创建组织,默认初始化审计相关字段.
   *
   * @param name 租户名称
   * @return 租户实体
   */
  public Organization createOrganization(String name) {
    Organization organization = createAbstractEntity();

    organization.setName(name);
    return organization;
  }

  @Override
  protected Organization getInstance() {
    return new Organization();
  }
}
