package com.ark.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @Classname ArkGatewaySecurityConfig
 * @Description TODO
 * @Date 2022/11/24 22:03
 * @Created by hang.li
 */
@Configuration
public class ArkGatewaySecurityConfig {
    @Bean
    SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) throws Exception {
        return http.httpBasic().and()
                .csrf().disable()
                .authorizeExchange()
                .pathMatchers("/**").authenticated()
                .anyExchange().permitAll()
                .and()
                .build();
    }
}
