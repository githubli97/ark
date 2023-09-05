package com.ark.identify.infrastructure.user;

import com.ark.identify.domain.user.Account;
import com.ark.infrastructure.base.Convertor;
import org.springframework.stereotype.Component;

/**
 * 用户实体向持久化对象实体转换.
 */
@Component
public class AccountConvertor implements Convertor<Account, AccountPo> {

  @Override
  public AccountPo getPersistentObjInstance() {
    return new AccountPo();
  }

  @Override
  public AccountPo domainObjToPersistentObj(
      AccountPo persistentObj, Account domainObj) {
    persistentObj.setUsername(domainObj.getUsername());
    persistentObj.setAccountType(domainObj.getAccountType().name());
    return persistentObj;
  }
}
