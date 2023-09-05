package com.ark.identify.domain.user;

import com.ark.core.base.BaseCommonEntity;
import com.ark.core.tag.TagEntity;
import java.util.List;

/**
 * 账户.
 */
public interface Account extends BaseCommonEntity, TagEntity {
  String getUsername();

  String getPassword();

  void setPassword(String password);

  List<User> getUsers();

  List<User> signin();

  Account signup();
}
