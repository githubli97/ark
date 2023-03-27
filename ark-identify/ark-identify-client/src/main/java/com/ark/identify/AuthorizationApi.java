package com.ark.identify;

import io.swagger.annotations.Api;
import org.springframework.cloud.openfeign.FeignClient;


@Api(value = "授权接口", tags = "授权接口")
@FeignClient(name = "AuthenticationApi", url = "${ark.feign.protocol}://${ark.service-domain.identify}")
public interface AuthorizationApi {
}
