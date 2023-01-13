package com.ark.identify.application.service.impl;

import com.ark.identify.application.query.AccountQueryService;
import com.ark.identify.application.query.dto.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class AccountSignInQueryService implements UserDetailsService {
    @Autowired
    private AccountQueryService accountQueryService;

    @Override
    public AccountDTO loadUserByUsername(String username) throws UsernameNotFoundException {
        // 尝试使用手机号登录
        AccountDTO account = accountQueryService.getAccountByPhone(username);

        return account;
    }
}