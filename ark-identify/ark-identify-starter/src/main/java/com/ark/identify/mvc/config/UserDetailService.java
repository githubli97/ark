package com.ark.identify.mvc.config;

import com.ark.userinfo.query.AccountInfo;
import com.ark.userinfo.query.UserinfoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserinfoApi userinfoApi;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountInfo userinfoByUsername = userinfoApi.getUserinfoById("username", username);
        return userinfoByUsername;
    }
}
