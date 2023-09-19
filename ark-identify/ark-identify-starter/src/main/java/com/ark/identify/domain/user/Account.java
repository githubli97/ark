package com.ark.identify.domain.user;

import com.ark.core.ddd.Entity;
import com.ark.identify.domain.user.value.Email;
import com.ark.identify.domain.user.value.GitHubAccount;
import com.ark.identify.domain.user.value.Password;
import com.ark.identify.domain.user.value.Phone;

/**
 * 账户.
 */
public interface Account extends Entity {
  String getUsername();

  String getPassword();

  void setPassword(Password password);

  /**
   * 手机号注册账户.
   */
  Account registeByPhone(Phone phone, Password password);

  /**
   * 短信验证码登录.
   */
  default void login(Phone phone, String code) {

  }

  /**
   * 注销.
   */
  default void logout() {}

  /**
   * 重置密码.
   *
   * @param newPassword 新的密码
   */
  default void changePassword(Password newPassword) {
    setPassword(newPassword);
  }

  /**
   * 绑定邮箱.
   *
   * @param email 邮箱
   */
  void bindEmail(Email email);

  /**
   * 绑定GitHub.
   *
   * @param gitHubAccount gitHubAccount
   */
  void bindGitHub(GitHubAccount gitHubAccount);
}
