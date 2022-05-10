package com.ark.generator.mp.main;

import com.ark.identify.domain.account.repository.AccountRepository;
import com.ark.identify.domain.tenant.repository.TenantRepository;
import org.junit.jupiter.api.Test;

public class Generator {

    @Test
    public void init() {
        ArkMPInfrastructureGenerator.generatorInit("identify", "tenant", TenantRepository.class);
    }

    @Test
    public void update() {
        ArkMPInfrastructureGenerator.generatorUpdatePO("identify", "tenant", TenantRepository.class);
    }
}
