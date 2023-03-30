package com.ark.userinfo.query;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * 账户信息
 */
@FeignClient(name = "UserinfoApi", url = "${ark.feign.protocol}://${ark.service-domain.userinfo}/${ark.service-name.userinfo}")
public interface UserinfoApi {

    /**
     * 获取用户信息
     *
     * @param argType 类型
     * @param arg     参数
     * @return 用户
     */
    @GetMapping("/user/{argType}/{arg}")
    AccountInfo getUserinfoById(@PathVariable("argType") String argType,
        @PathVariable("arg") String arg);
}
