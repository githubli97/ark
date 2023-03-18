package com.ark.userinfo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArkGrantedAuthority implements GrantedAuthority, Serializable {

    private String authority;
    @Override
    public String getAuthority() {
        return authority;
    }
}
