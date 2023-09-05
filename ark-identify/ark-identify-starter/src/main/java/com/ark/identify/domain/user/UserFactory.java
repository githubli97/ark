package com.ark.identify.domain.user;

import com.ark.domain.AbstractEntityFactory;
import com.ark.identify.domain.tenant.Tenant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 用户实体工厂.
 */
@Service
@AllArgsConstructor
public class UserFactory extends AbstractEntityFactory<User> {
  private AccountFactory accountFactory;

  /**
   * 创建员工,默认初始化审计相关字段.
   */
  public User joinTenant(Account account, Tenant tenant) {
    User user = createAbstractEntity();

    return user;
  }

  @Override
  protected User getInstance() {
    return null;
  }
}
