package com.ark.identify.domain.user;

import com.ark.core.ddd.Entity;
import com.ark.core.tag.TagEntity;
import com.ark.identify.domain.user.value.Email;
import com.ark.identify.domain.user.value.GitHubAccount;

/**
 * 账户领域服务.
 */
public interface AccountService extends Entity, TagEntity {

  /**
   * 手机号注册账户.
   */
  void registeByPhone(String phone, String password);

  /**
   * 短信验证码登录.
   */
  void login(String phone, String password);

  /**
   * 注销.
   */
  void logout();

  /**
   * 重置密码.
   *
   * @param newPassword 新的密码
   */
  void changePassword(String newPassword);

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
