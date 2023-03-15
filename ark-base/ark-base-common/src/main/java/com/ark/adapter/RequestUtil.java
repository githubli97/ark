package com.ark.adapter;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;


/**
 * @Classname RequestUtil
 * @Description 操作Request, response对象工具类
 * @Date 2022/11/20 15:57
 * @Created by hang.li
 */
public class RequestUtil {

    public static HttpServletRequest getRequest() {
        HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        return req;
    }


    public static HttpServletResponse getResponse() {
        HttpServletResponse resp = ((ServletWebRequest)RequestContextHolder.getRequestAttributes()).getResponse();
        return resp;
    }

    public static void addCookie(Cookie cookie) {
        HttpServletResponse resp = getResponse();
        resp.addCookie(cookie);
    }

    public static void addHeader(String key, String value) {
        HttpServletResponse resp = getResponse();
        resp.addHeader(key, value);
    }
}
