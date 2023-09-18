package com.ark.identify.domain.user;

import com.ark.core.ddd.Entity;
import com.ark.identify.domain.user.value.Email;
import com.ark.identify.domain.user.value.GitHubAccount;
import com.ark.identify.domain.user.value.Password;

/**
 * 账户.
 */
public interface Account extends Entity {
  String getUsername();

  String getPassword();

  /**
   * 手机号注册账户.
   */
  void checkPassword(Password password);

  /**
   * 重置密码.
   *
   * @param newPassword 新的密码
   */
  void changePassword(Password newPassword);

  /**
   * 绑定邮箱.
   *
   * @param email 邮箱
   */
  void bindEmail(Email email);

  /**
   * 绑定GitHub.
   *
   * @param gitHubAccount GitHub用户名
   */
  void bindGitHub(GitHubAccount gitHubAccount);
}
