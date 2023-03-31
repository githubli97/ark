package com.ark.identify.application;

import com.ark.ApplicationTest;
import com.ark.identify.application.service.tenant.TenantApplicationService;
import com.ark.identify.application.service.tenant.command.CreateTenantByPhoneCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TenantApplicationServiceTests extends ApplicationTest {

  @Autowired
  private TenantApplicationService tenantApplicationService;

  @Test
  public void testCreateTenantByPhone() {
    // 创建 CreateTenantByPhoneCommand 对象
    CreateTenantByPhoneCommand command = new CreateTenantByPhoneCommand();
    command.setPhone("123456789");
    command.setTenantName("Test");
    command.setVerifyCode("123456");

    // 调用方法
    for (int i = 0; i < 1000; i++) {
      command.setTenantName("租户" + i + 1);
      tenantApplicationService.createTenantByPhone(command);
    }

    // 验证结果
    // TODO: 根据实际情况编写验证代码
  }
}
