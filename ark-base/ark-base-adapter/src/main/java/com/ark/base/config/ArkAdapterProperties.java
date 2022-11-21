package com.ark.base.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@Getter
@ConfigurationProperties(prefix = ArkAdapterProperties.ARK_ADAPTER_PREFIX)
public class ArkAdapterProperties {
    public static final String ARK_ADAPTER_PREFIX = "ark.adapter";

    private Map<String, String> paramKeys;
}