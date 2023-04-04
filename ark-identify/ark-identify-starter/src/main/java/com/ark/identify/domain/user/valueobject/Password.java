package com.ark.identify.domain.user.valueobject;

import com.ark.domain.helper.ApplicationContextHelper;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 密码值对象.
 */
public class Password {
  private final PasswordEncoder passwordEncoder =
      ApplicationContextHelper.getBean(PasswordEncoder.class);
  private String value;

  public Password(String value) {
    this.value = passwordEncoder.encode(value);
  }


  public boolean checkPassword(String password) {
    return passwordEncoder.matches(password, value);
  }
}
