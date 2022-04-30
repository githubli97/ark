package com.ark.identify.domain.account;

import com.ark.identify.domain.account.entity.phone.PhoneAccount;

public interface PhoneAccountRepository {
    /**
     * 保存租户，并返回主键
     */
    PhoneAccount save(PhoneAccount account);
}
