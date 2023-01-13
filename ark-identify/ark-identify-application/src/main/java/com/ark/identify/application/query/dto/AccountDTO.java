package com.ark.identify.application.query.dto;

import com.ark.identify.infrastucture.persistence.account.model.AccountPO;
import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @Classname AccountDTO
 * @Description AccountDTO
 * @Date 2022/11/24 9:37
 * @Created by hang.li
 */
@Data
public class AccountDTO implements UserDetails {
    private Long id;
    private String username;
    private String password;
    private List<String> authorityList;

    public static AccountDTO convertThis(AccountPO accountPO) {
        return new AccountDTO()
                .setId(accountPO.getId())
                .setUsername(String.valueOf(accountPO.getId()))
                .setPassword(accountPO.getPassword())
                .setAuthorityList(Lists.newArrayList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList(getAuthorityList().toArray(new String[]{}));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
