package com.ark.identify.mvc.tenant.controller;


import com.ark.common.dto.Response;
import com.ark.identify.application.service.command.SignInByPasswordCommand;
import com.ark.identify.application.service.command.SignInBySmsCommand;
import com.ark.identify.application.service.SignInApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录
 */
@RestController
@RequestMapping("/signin")
public class SignInController {
    @Autowired
    private SignInApplicationService signInApplicationService;
    /**
     * 登录
     */
    @PostMapping("password")
    public Response signInByPassword(@RequestBody SignInByPasswordCommand command) {
        return signInApplicationService.signInByPassword(command);
    }

    /**
     * 登录
     */
    @PostMapping("sms")
    public Response signInBySms(@RequestBody SignInBySmsCommand command) {
        return signInApplicationService.signInBySms(command);
    }
}
