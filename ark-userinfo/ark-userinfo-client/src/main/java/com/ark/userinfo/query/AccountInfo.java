package com.ark.userinfo.query;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountInfo implements UserDetails, Serializable {
    private String username;
    private String password;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;
    private Set<ArkGrantedAuthority> authorities;
    private String userProfilePicture;

    public AccountInfo(String username, String password, Collection<ArkGrantedAuthority> authorities) {
        this(username, password, true, true, true, true, Sets.newHashSet(authorities), null);
    }
}
