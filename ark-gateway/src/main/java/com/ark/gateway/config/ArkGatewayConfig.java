package com.ark.gateway.config;

import com.ark.gateway.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArkGatewayConfig {
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Bean
	public RouteLocator arkRouteLocator(RouteLocatorBuilder builder) {
		//@formatter:off
		return builder.routes()
				.route("path_route", r -> r.path("/identify/login*")
						.uri("http://127.0.0.1:10010"))
				.route("token", r -> r.path("/identify/system/ping")
							.filters(f -> f.addRequestHeader("jwt-token",
									jwtTokenUtil.getJwtToken()))
				.uri("http://127.0.0.1:9010"))
//				.route("host_route", r -> r.host("*.myhost.org")
//						.uri("http://httpbin.org"))
//				.route("rewrite_route", r -> r.host("*.rewrite.org")
//						.filters(f -> f.rewritePath("/foo/(?<segment>.*)",
//								"/${segment}"))
//						.uri("http://httpbin.org"))
				// 熔断
//				.route("circuitbreaker_route", r -> r.host("*.circuitbreaker.org")
//						.filters(f -> f.circuitBreaker(c -> c.setName("slowcmd")))
//								.uri("http://httpbin.org"))
//				.route("circuitbreaker_fallback_route", r -> r.host("*.circuitbreakerfallback.org")
//						.filters(f -> f.circuitBreaker(c -> c.setName("slowcmd").setFallbackUri("forward:/circuitbreakerfallback")))
//								.uri("http://httpbin.org"))
				// 流量整形
//				.route("limit_route", r -> r
//					.host("*.limited.org").and().path("/anything/**")
//						.filters(f -> f.requestRateLimiter(c -> c.setRateLimiter(redisRateLimiter())))
//					.uri("http://httpbin.org"))
				// ws
				.route("websocket_route", r -> r.path("/echo")
					.uri("ws://localhost:9000"))
				.build();
		//@formatter:on
	}
}
