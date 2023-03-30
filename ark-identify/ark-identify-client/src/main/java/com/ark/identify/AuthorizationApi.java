package com.ark.identify;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * 授权接口.
 */
@FeignClient(name = "AuthenticationApi", url = "${ark.feign.protocol}://${ark.service-domain.identify}")
public interface AuthorizationApi {

}
