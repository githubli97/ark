package com.ark.adapter.controller;


import com.ark.common.dto.Response;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * 登录
 */
@RestController
@RequestMapping("/system")
public class SystemController {
    @GetMapping("ping")
    public Response<String> ping(HttpServletRequest request) {
        request.getRequestURL();
        return Response.ok("pong");
    }
}
