package com.ark.identify.application.service.tenant.command;

import com.ark.identify.domain.tenant.Tenant;
import com.ark.identify.domain.tenant.TenantFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TenantCommandHandler {

  private TenantFactory tenantFactory;

  public Tenant doFromCreateTenantByPhoneCommand(
      CreateTenantByPhoneCommand createTenantByPhoneCommand) {
    return tenantFactory.createTenant(createTenantByPhoneCommand.getTenantName());
  }
}
