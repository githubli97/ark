package com.ark.identify.domain.user;

import com.ark.domain.AbstractEntityFactory;
import com.ark.identify.domain.organiztion.Organization;
import com.ark.identify.domain.user.valueobject.AccountTypeEnum;
import com.ark.identify.domain.user.valueobject.Password;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 用户实体工厂.
 */
@Service
@AllArgsConstructor
public class AccountFactory extends AbstractEntityFactory<Account> {
  /**
   * 创建账号,默认初始化审计相关字段.
   */
  public Account createAccount(String username, AccountTypeEnum accountType) {
    Account account = createAbstractEntity();
    account.accountType = accountType;
    account.username = username;

    return account;
  }


  @Override
  protected Account getInstance() {
    return new Account();
  }
}
