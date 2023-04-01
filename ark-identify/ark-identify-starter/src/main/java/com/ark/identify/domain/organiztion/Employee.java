package com.ark.identify.domain.organiztion;

import com.ark.identify.domain.user.User;
import java.time.LocalDate;

/**
 * 组织员工领域实体.
 */
public class Employee extends User {

  private String gender;
  private LocalDate birthday;
  private Organization organization;

  @Override
  protected void assertVerifyName(String name) {
  }
}
