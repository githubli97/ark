package com.ark.identify.mvc.tenant.config;

import com.ark.identify.application.query.AccountQueryService;
import com.ark.identify.application.query.dto.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class AccountSignInQueryService implements UserDetailsService {
    @Autowired
    private AccountQueryService accountQueryService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 尝试使用手机号登录
        AccountDTO account = accountQueryService.getAccountByPhone(username);

        return new User(username,
                account.getPassword(),
                AuthorityUtils.createAuthorityList());
    }
}