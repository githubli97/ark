package com.ark.facade.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> ping(HttpServletRequest request) {
        request.getRequestURL();
        return ResponseEntity.ok("pong");
    }
}
