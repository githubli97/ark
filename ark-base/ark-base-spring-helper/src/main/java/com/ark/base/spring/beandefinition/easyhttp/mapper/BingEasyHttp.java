package com.ark.base.spring.beandefinition.easyhttp.mapper;

import com.ark.base.spring.beandefinition.easyhttp.annotation.EasyHttpDomain;
import com.ark.base.spring.beandefinition.easyhttp.annotation.EasyHttpUri;

/**
 * @Classname BaiduEasyHttp
 * @Description TODO
 * @Date 2022/6/30 9:44
 * @Created by hang.li
 */
@EasyHttpDomain(protocol = "http", domain = "www.bing.com")
public interface BingEasyHttp {
    @EasyHttpUri("/")
    String index();
}
