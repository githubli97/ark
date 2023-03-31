package com.ark.userinfo.query;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

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
