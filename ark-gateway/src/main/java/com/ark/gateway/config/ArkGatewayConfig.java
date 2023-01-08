package com.ark.gateway.config;

import com.ark.gateway.filter.AddJwtTokenGatewayFilterFactory;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.config.conditional.ConditionalOnEnabledFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;

import java.security.interfaces.RSAPublicKey;
import java.security.interfaces.RSAPrivateKey;

@Configuration
public class ArkGatewayConfig {
    @Value("${ark.jwt.public.key}")
    private RSAPublicKey key;
    @Value("${ark.jwt.private.key}")
    private RSAPrivateKey priv;

    private volatile JwtEncoder jwtEncoder;


    @Bean
    public JwtEncoder jwtEncoder() {
        JWK jwk = new RSAKey.Builder(this.key).privateKey(this.priv).build();
        JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
        jwtEncoder = new NimbusJwtEncoder(jwks);
        return jwtEncoder;
    }

    @Bean
    @ConditionalOnEnabledFilter
    public AddJwtTokenGatewayFilterFactory addJwtTokenGatewayFilterFactory() {
        return new AddJwtTokenGatewayFilterFactory(jwtEncoder);
    }
}
