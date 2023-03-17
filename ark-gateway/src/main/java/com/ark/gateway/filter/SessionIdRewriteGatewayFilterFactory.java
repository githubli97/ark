//package com.ark.gateway.filter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//
//@Component
//public class SessionIdRewriteGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {
//
//    @Autowired
//    private RestTemplate restTemplate; // 使用 Spring 的 RestTemplate 来发送 HTTP 请求
//
//    @Value("${auth-service-url}")
//    private String authServiceUrl; // 配置认证服务的 URL
//
//    @Override
//    public GatewayFilter apply(Object config) {
//        return (exchange, chain) -> { // 使用 Lambda 表达式定义一个 GatewayFilter
//            ServerHttpRequest request = exchange.getRequest(); // 获取 Gateway 的请求
//            HttpHeaders headers = request.getCookies(); // 获取请求头
//            List<String> cookieHeaders = headers.get("Cookie"); // 获取 Cookie 头
//            String sessionId = null; // 初始化 sessionId 为 null
//            if (cookieHeaders != null) { // 如果 Cookie 头不为空
//                for (String cookieHeader : cookieHeaders) { // 遍历 Cookie 头中的每个 Cookie
//                    for (String cookie : cookieHeader.split(";")) { // 遍历每个 Cookie 的键值对
//                        if (cookie.startsWith("JSESSIONID=")) { // 如果 Cookie 的键是 JSESSIONID
//                            sessionId = cookie.substring("JSESSIONID=".length()); // 获取 JSESSIONID 的值
//                            break; // 结束循环
//                        }
//                    }
//                }
//            }
//            if (sessionId != null) { // 如果 sessionId 不为空
//                // remove JSESSIONID from the request headers
//                headers.remove("Cookie"); // 从请求头中移除 JSESSIONID
//                headers.add("Cookie", ""); // 添加一个空的 Cookie 头
//                // forward the request to the authentication service
//                String url = authServiceUrl + "/authenticate?sessionId=" + sessionId; // 构造认证服务的 URL
//                HttpEntity<String> httpEntity = new HttpEntity<>(headers); // 构造一个 HTTP 请求实体
//                ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class); // 发送 HTTP GET 请求到认证服务
//                // get the response headers from the authentication service
//                HttpHeaders responseHeaders = responseEntity.getHeaders(); // 获取认证服务响应的响应头
//                List<String> setCookieHeaders = responseHeaders.get("Set-Cookie"); // 获取认证服务响应的 Set-Cookie 头
//                if (setCookieHeaders != null) { // 如果 Set-Cookie 头不为空
//                    // copy the Set-Cookie headers from the authentication service to the gateway response headers
//                    for (String setCookieHeader : setCookieHeaders) { // 遍历认证服务响应的 Set-Cookie 头中的每个 Cookie
//                        exchange.getResponse().addCookie(setCookieHeader); // 将每个 Cookie 添加到 Gateway 响应的 Set-Cookie 头中
//                    }
//                }
//                // forward the authentication service response to the client
//                return exchange.getResponse().writeWith(responseEntity.getBodyPublisher()); // 将认证服务响应转发给客户端
//            } else { // 如果 sessionId 为空
//                // no JSESSIONID found, continue with the chain
//                return chain.filter(exchange); // 继续执行 Gateway 的过滤器链
//            }
//        };
//    }
//}
