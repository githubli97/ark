package com.ark.identify.domain.account.repository;

import com.ark.domain.base.ArkRepository;
import com.ark.identify.domain.account.entity.Account;

public interface AccountRepository extends ArkRepository<Account> {
    Account getByPhone(String phone);
}
