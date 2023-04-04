package com.ark.identify.domain.user;

import com.ark.domain.AbstractCommonEntity;
import com.ark.identify.domain.organiztion.Organization;
import com.ark.identify.domain.user.valueobject.Password;
import com.google.common.base.Preconditions;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;

/**
 * 组织员工领域实体.
 */
@Getter
public class User extends AbstractCommonEntity {
  Long tenantId;
  Password password;
  String email;
  String phone;
  String gender;
  LocalDate birthday;
  Organization organization;
  List<Account> accountList;

  @Override
  protected void assertVerifyName(String name) {
    Preconditions.checkNotNull(name, "用户姓名必填");
    Preconditions.checkArgument(name.length() < 20 && name.length() > 0, "用户姓名应该小于20个字", name);
  }
}
