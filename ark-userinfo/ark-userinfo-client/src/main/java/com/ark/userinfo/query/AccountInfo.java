package com.ark.userinfo.query;

import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 适配spring security 用户的实现类.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountInfo implements UserDetails, CredentialsContainer, Serializable {

  private Long id;
  private String username;
  private String realName;
  private String password;

  private boolean accountNonExpired;

  private boolean accountNonLocked;

  private boolean credentialsNonExpired;

  private boolean enabled;
  private Set<ArkGrantedAuthority> authorities;
  private String userProfilePicture;

  public AccountInfo(String username, String realName, String password,
                     Collection<ArkGrantedAuthority> authorities, String userProfilePicture) {
    this(1L, username, realName, password, true, true, true, true, Sets.newHashSet(authorities),
        userProfilePicture);
  }

  @Override
  public void eraseCredentials() {
    this.password = null;
  }
}
