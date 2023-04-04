package com.ark.identify.application.service.tenant;

import com.ark.identify.application.service.tenant.command.CreateTenantByPhoneCommand;
import com.ark.identify.application.service.tenant.command.TenantCommandHandler;
import com.ark.identify.domain.organiztion.OrganizationService;
import com.ark.identify.domain.tenant.Tenant;
import com.ark.identify.domain.tenant.TenantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 租户应用服务.
 */
@Service
@AllArgsConstructor
public class TenantApplicationService {

  private TenantService tenantService;
  private OrganizationService organizationService;
  private TenantCommandHandler tenantCommandHandler;

  /**
   * 根据手机号创建租户.
   *
   * @param createTenantByPhoneCommand 手机号创建租户命令
   */
  @Transactional
  public void createTenantByPhone(CreateTenantByPhoneCommand createTenantByPhoneCommand) {
    // 创建租户
    Tenant tenant = tenantCommandHandler.doFromCreateTenantByPhoneCommand(
        createTenantByPhoneCommand);
    tenantService.store(tenant);

    // 创建组织
    organizationService.createTenantOrganization(tenant.getName(),
        createTenantByPhoneCommand.getPhone());
  }
}
