package com.ark.gateway.filter;

import com.ark.base.spring.aware.ArkApplicationContextAware;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.stream.Collectors;

public class AddJwtTokenGatewayFilter implements GatewayFilter, Ordered {
    public static final String JWT_TOKEN_PREFIX = "Bearer ";


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return ReactiveSecurityContextHolder.getContext().map(SecurityContext::getAuthentication)
                .map((authentication) -> {
                    String value = JWT_TOKEN_PREFIX + getJwtToken(authentication);
                    exchange.getRequest().mutate()
                            .headers((httpHeaders) -> httpHeaders.add("Authorization", value))
                            .build();
                    return chain.filter(exchange.mutate().request(exchange.getRequest()).build()).block();
                });
    }

    private static String getJwtToken(Authentication authentication) {
        JwtEncoder jwtEncoder = ArkApplicationContextAware.applicationContext.getBean("jwtEncoder", JwtEncoder.class);

        Instant now = Instant.now();
        long expiry = 36000L;
        String scope = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject(authentication.getName())
                .claim("scope", scope)
                .build();
        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    @Override
    public int getOrder() {
        return 0;
    }
}