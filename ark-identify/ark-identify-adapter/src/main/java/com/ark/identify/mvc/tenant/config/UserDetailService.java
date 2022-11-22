package com.ark.identify.mvc.tenant.config;

import com.ark.identify.application.service.AccountQueryService;
import com.ark.identify.domain.account.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class UserDetailService implements UserDetailsService {
    @Autowired
    private AccountQueryService accountQueryService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountQueryService.getAccount(username);

        return new User(account.getChinaPhone().getPhoneNumber(), account.getPassword().getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}