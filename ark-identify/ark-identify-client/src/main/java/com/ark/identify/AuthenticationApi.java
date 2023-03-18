package com.ark.identify;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Api(value = "鉴权接口", tags = "鉴权接口")
@FeignClient(name = "AuthenticationApi", url = "${ark.feign.protocol}://${ark.service-name.identify}")
public interface AuthenticationApi {
    @ApiOperation(value = "对服务下uri鉴权", notes = "用户信息")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "long", paramType = "arg")
    @PostMapping("/authentication/{serviceName}/{uri}")
    boolean authentication(@PathVariable("serviceName") String serviceName, @PathVariable("uri") String uri);
}
