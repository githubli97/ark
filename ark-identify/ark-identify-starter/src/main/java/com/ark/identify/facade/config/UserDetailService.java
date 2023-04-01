package com.ark.identify.facade.config;

import com.ark.userinfo.query.UserinfoApi;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * spring security 持久化用户登录.
 */
@Configuration
@AllArgsConstructor
public class UserDetailService implements UserDetailsService {

  private UserinfoApi userinfoApi;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userinfoApi.getUserinfoById("username", username);
  }
}
