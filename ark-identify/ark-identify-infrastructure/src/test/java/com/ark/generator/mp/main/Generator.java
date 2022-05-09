package com.ark.generator.mp.main;

import com.ark.identify.domain.account.repository.AccountRepository;
import org.junit.jupiter.api.Test;

public class Generator {

    @Test
    public void init() {
        ArkMPInfrastructureGenerator.generatorInit("identify", "account", AccountRepository.class);
    }

    @Test
    public void update() {
        ArkMPInfrastructureGenerator.generatorUpdatePO("identify", "account", AccountRepository.class);
    }
}
