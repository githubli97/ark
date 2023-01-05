package com.ark.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static org.springframework.cloud.gateway.support.GatewayToStringStyler.filterToStringCreator;

public class AddJwtTokenGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {
    public static final String JWT_TOKEN_PREFIX = "Bearer ";

    @Override
    public GatewayFilter apply(NameValueConfig config) {
        return new GatewayFilter(){
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                String value = JWT_TOKEN_PREFIX + authentication.toString();
                ServerHttpRequest request = exchange.getRequest().mutate().headers((httpHeaders) -> {
                    httpHeaders.add("Authorization", value);
                }).build();
                return chain.filter(exchange.mutate().request(request).build());
            }

            @Override
            public String toString() {
                return filterToStringCreator(AddJwtTokenGatewayFilterFactory.this)
                        .append(config.getName(), config.getValue()).toString();
            }
        };
    }
}