package com.ark.identify.service.cmd.account;

/**
 * 账户accountcmd服务.
 */
public interface AccountCmdService {
  void create(String phone);

  /**
   * 登录.
   * 1. 校验密码是否正确.
   * 2. 生成token.
   * 3. 缓存token.
   * 4. 发送认证成功事件.
   */
  void login(String phone, String password);

  /**
   * 登出.
   * 1. 清除token.
   * 2. 发送登出事件.
   */
  void logout();
}
