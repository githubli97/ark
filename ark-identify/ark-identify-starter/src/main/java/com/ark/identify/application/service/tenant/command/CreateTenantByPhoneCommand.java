package com.ark.identify.application.service.tenant.command;

import lombok.Data;

/**
 * 根据手机号创建租户命令.
 */
@Data
public class CreateTenantByPhoneCommand {

  private String phone;
  private String tenantName;
  private String verifyCode;
}
