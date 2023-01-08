package com.ark.gateway.filter;

import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.security.oauth2.jwt.JwtEncoder;

@AllArgsConstructor
public class AddJwtTokenGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {
    private JwtEncoder jwtEncoder;
    @Override
    public GatewayFilter apply(Object config) {
        return new AddJwtTokenGatewayFilter(jwtEncoder);
    }
}