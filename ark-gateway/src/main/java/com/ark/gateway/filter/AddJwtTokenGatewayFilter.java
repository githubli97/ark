package com.ark.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class AddJwtTokenGatewayFilter implements GatewayFilter, Ordered {
    public static final String JWT_TOKEN_PREFIX = "Bearer ";


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return ReactiveSecurityContextHolder.getContext().map(SecurityContext::getAuthentication)
                .map((authentication) -> {
                    String value = JWT_TOKEN_PREFIX + authentication.toString();
                    exchange.getRequest().mutate()
                            .headers((httpHeaders) -> httpHeaders.add("Authorization", value))
                            .build();
                    return chain.filter(exchange.mutate().request(exchange.getRequest()).build()).block();
                });
    }

    @Override
    public int getOrder() {
        return 0;
    }
}