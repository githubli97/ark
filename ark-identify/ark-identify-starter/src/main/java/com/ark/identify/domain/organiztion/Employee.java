package com.ark.identify.domain.organiztion;

import com.ark.identify.domain.user.User;
import java.time.LocalDate;

public class Employee extends User {

  private String gender;
  private LocalDate birthday;
  private Organiztion organiztion;

  @Override
  protected void assertVerifyName(String name) {
  }
}
