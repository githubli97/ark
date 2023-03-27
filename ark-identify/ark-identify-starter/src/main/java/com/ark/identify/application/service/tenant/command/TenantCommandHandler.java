package com.ark.identify.application.service.tenant.command;

import com.ark.identify.domain.tenant.Tenant;
import org.springframework.stereotype.Service;

@Service
public class TenantCommandHandler {
    public Tenant doFromCreateTenantByPhoneCommand(CreateTenantByPhoneCommand createTenantByPhoneCommand) {
        return new Tenant();
    }
}
