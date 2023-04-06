package com.ark.identify.domain.user;

import com.ark.domain.AbstractEntity;
import com.ark.identify.domain.user.valueobject.AccountTypeEnum;
import lombok.Getter;

/**
 * 账户领域.
 */
@Getter
public class Account extends AbstractEntity {

  String username;
  AccountTypeEnum accountType;
}
