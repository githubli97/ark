package com.ark.base.spring.beandefinition.easyhttp.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Classname BaiduEasyHttp
 * @Description TODO
 * @Date 2022/6/30 9:44
 * @Created by hang.li
 */
@Target({METHOD})
@Retention(RUNTIME)
public @interface EasyHttpUri {
    String value();
}
