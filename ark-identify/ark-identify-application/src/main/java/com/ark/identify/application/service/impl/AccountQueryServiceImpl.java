package com.ark.identify.application.service.impl;

import com.ark.identify.application.service.AccountQueryService;
import com.ark.identify.domain.account.entity.Account;
import com.ark.identify.domain.account.service.AccountDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountQueryServiceImpl implements AccountQueryService {
    @Autowired
    private AccountDomainService accountDomainService;
    @Override
    public Account getAccount(String username) {
        return accountDomainService.getByPhone(username);
    }
}
