package com.ark.gateway.config;

import com.ark.gateway.filter.AddJwtTokenGatewayFilterFactory;
import org.springframework.cloud.gateway.config.conditional.ConditionalOnEnabledFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArkGatewayConfig {
    @Bean
    @ConditionalOnEnabledFilter
    public AddJwtTokenGatewayFilterFactory addJwtTokenGatewayFilterFactory() {
        return new AddJwtTokenGatewayFilterFactory();
    }
//	@Bean
//	public RouteLocator arkRouteLocator(RouteLocatorBuilder builder) {
//		//@formatter:off
//		return builder.routes()
//				.route("path_route", r -> r.path("/message")
//						.uri("http://ark-simple-resource"))
//				.build();
////				.route("host_route", r -> r.host("*.myhost.org")
////						.uri("http://httpbin.org"))
////				.route("rewrite_route", r -> r.host("*.rewrite.org")
////						.filters(f -> f.rewritePath("/foo/(?<segment>.*)",
////								"/${segment}"))
////						.uri("http://httpbin.org"))
//				// 熔断
////				.route("circuitbreaker_route", r -> r.host("*.circuitbreaker.org")
////						.filters(f -> f.circuitBreaker(c -> c.setName("slowcmd")))
////								.uri("http://httpbin.org"))
////				.route("circuitbreaker_fallback_route", r -> r.host("*.circuitbreakerfallback.org")
////						.filters(f -> f.circuitBreaker(c -> c.setName("slowcmd").setFallbackUri("forward:/circuitbreakerfallback")))
////								.uri("http://httpbin.org"))
//				// 流量整形
////				.route("limit_route", r -> r
////					.host("*.limited.org").and().path("/anything/**")
////						.filters(f -> f.requestRateLimiter(c -> c.setRateLimiter(redisRateLimiter())))
////					.uri("http://httpbin.org"))
//				// ws
////				.route("websocket_route", r -> r.path("/echo")
////					.uri("ws://localhost:9000"))
//		//@formatter:on
//	}
}
