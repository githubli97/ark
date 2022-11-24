package com.ark.identify.application.query.impl;

import com.ark.identify.application.query.AccountQueryService;
import com.ark.identify.application.query.dto.AccountDTO;
import com.ark.identify.infrastucture.persistence.account.model.AccountPO;
import com.ark.identify.infrastucture.persistence.account.repository.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountQueryServiceImpl implements AccountQueryService {
    @Autowired
    private IAccountService iAccountService;

    @Override
    public AccountDTO getAccountByPhone(String username) {
        AccountPO accountPO = iAccountService.selectByPhone(username);
        return AccountDTO.convertThis(accountPO);
    }
}
