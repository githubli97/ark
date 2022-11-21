package com.ark.generator.mp.main;

import com.baomidou.mybatisplus.extension.service.IService;
import org.junit.jupiter.api.Test;

public class Generator {

    @Test
    public void init() {
        ArkMPInfrastructureGenerator.generatorInit("identify", "unique_user", IService.class);
    }

    @Test
    public void update() {
        ArkMPInfrastructureGenerator.generatorUpdatePO("identify", "unique_user", IService.class);
    }

    @Test
    public void poAndMapper() {
        ArkMPInfrastructureGenerator.generatorPOAndMapper("identify", "unique_user", IService.class);
    }
}
