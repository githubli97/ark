package com.ark.identify.domain.account.repository;

import com.ark.base.domain.base.ArkRepository;
import com.ark.base.domain.phone.ChinaPhone;
import com.ark.identify.domain.account.entity.Account;
import com.ark.identify.domain.account.entity.valueobject.Password;

import java.util.Optional;

public interface AccountRepository extends ArkRepository<Account> {
    Optional<Account> selectByPhoneAndPassword(ChinaPhone phone, Password password);
}
