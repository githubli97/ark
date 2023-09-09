package com.ark.identify.application;

import com.ark.ApplicationTest;
import com.ark.identify.application.service.tenant.command.CreateTenantByPhoneCommand;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 租户应用服务测试类.
 */
public class TenantApplicationServiceTests extends ApplicationTest {

  @Autowired
  private TenantApplicationService tenantApplicationService;
  @Autowired
  private Faker faker;

  @Test
  public void testCreateTenantByPhone() {
    // 创建 CreateTenantByPhoneCommand 对象
    CreateTenantByPhoneCommand command = new CreateTenantByPhoneCommand();
    command.setPhone(faker.phoneNumber().phoneNumber());
    command.setTenantName(faker.company().name());
    command.setVerifyCode(faker.currency().code());

    // 调用方法
    for (int i = 0; i < 10; i++) {
      command.setTenantName("租户" + i + 1);
      tenantApplicationService.createTenantByPhone(command);
    }

    // 验证结果
    // TODO: 根据实际情况编写验证代码
  }
}
