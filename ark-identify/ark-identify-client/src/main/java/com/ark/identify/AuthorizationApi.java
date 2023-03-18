package com.ark.identify;

import com.ark.common.ClientApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.filter.HiddenHttpMethodFilter;


@Api(value = "授权接口", tags = "授权接口")
@FeignClient(name = "AuthenticationApi", url = "${ark.feign.protocol}://${ark.service-name.identify}")
public interface AuthorizationApi extends ClientApi {
}
