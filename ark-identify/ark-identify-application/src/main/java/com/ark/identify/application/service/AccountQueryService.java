package com.ark.identify.application.service;

import com.ark.identify.domain.account.entity.Account;

public interface AccountQueryService {
    Account getAccount(String username);
}
