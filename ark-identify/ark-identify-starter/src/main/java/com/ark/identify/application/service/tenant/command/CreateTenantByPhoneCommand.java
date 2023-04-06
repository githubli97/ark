package com.ark.identify.application.service.tenant.command;

import lombok.Data;

/**
 * 根据手机号创建租户命令.
 */
@Data
public class CreateTenantByPhoneCommand {

  /**
   * 手机号.
   */
  private String phone;
  /**
   * 租户名称.
   */
  private String tenantName;
  /**
   * 手机验证码.
   */
  private String verifyCode;
}
