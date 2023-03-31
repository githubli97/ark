package com.ark.identify;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 鉴权接口
 */
@FeignClient(name = "AuthenticationApi", url = "${ark.feign.protocol}://${ark.service-domain.identify}")
public interface AuthenticationApi {

  /**
   * 对服务下uri鉴权
   *
   * @param serviceName 服务名
   * @param uri         资源id
   * @return 通过校验
   */
  @PostMapping("/authentication/{serviceName}/{uri}")
  boolean authentication(@PathVariable("serviceName") String serviceName,
                         @PathVariable("uri") String uri);
}
