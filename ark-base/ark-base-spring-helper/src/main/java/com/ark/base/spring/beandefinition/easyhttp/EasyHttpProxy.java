package com.ark.base.spring.beandefinition.easyhttp;

import com.ark.base.spring.beandefinition.easyhttp.annotation.EasyHttpDomain;
import com.ark.base.spring.beandefinition.easyhttp.annotation.EasyHttpUri;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Classname EasyHttpFactoryBean
 * @Description TODO
 * @Date 2022/6/30 9:44
 * @Created by hang.li
 */
@Slf4j
@Data
@AllArgsConstructor
public class EasyHttpProxy<T> implements InvocationHandler, Serializable {
    public OkHttpClient httpClient;
    private Class<T> interfaceClass;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Request request = new Request.Builder()
                .get()
                .url(interfaceClass.getAnnotation(EasyHttpDomain.class).protocol() + "://"
                        + interfaceClass.getAnnotation(EasyHttpDomain.class).domain()
                        + method.getAnnotation(EasyHttpUri.class).value())
                .build();
        return new String(httpClient.newCall(request).execute().body().bytes());
    }
}
