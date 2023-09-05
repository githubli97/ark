package com.ark.identify.domain.user;

import com.ark.identify.domain.tenant.Tenant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 组织领域服务类.
 */
@Service
@AllArgsConstructor
public class UserService {
  public UserFactory userFactory;

  void joinTenant(Account account, Tenant tenant) {
    return userFactory.joinTenant(account, tenant);
  }
}