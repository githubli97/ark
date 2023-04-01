package com.ark.userinfo.query;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

/**
 * 适配spring security 权限实现类.
 */
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
