package com.ark.identify.application.service.tenant;

import com.ark.identify.application.service.tenant.command.CreateTenantByPhoneCommand;
import com.ark.identify.application.service.tenant.command.TenantCommandHandler;
import com.ark.identify.domain.tenant.Tenant;
import com.ark.identify.domain.tenant.TenantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class TenantApplicationService {
    private TenantService tenantService;
    private TenantCommandHandler tenantCommandHandler;

    @Transactional
    public void createTenantByPhone(CreateTenantByPhoneCommand createTenantByPhoneCommand) {
        // 创建租户
        Tenant tenant = tenantCommandHandler.doFromCreateTenantByPhoneCommand(createTenantByPhoneCommand);
        tenantService.store(tenant);

        // 创建组织
        // 创建用户
    }
}
