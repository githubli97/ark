package com.ark.identify.domain.user.valueobject;

import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 密码值对象.
 */
@Getter
public class Password {
  private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
  String value;

  public Password(String value) {
    this.value = passwordEncoder.encode(value);
  }


  public boolean checkPassword(String password) {
    return passwordEncoder.matches(password, value);
  }
}
