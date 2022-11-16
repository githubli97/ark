package com.ark.identify.mvc.tenant.controller;


import com.ark.common.dto.Response;
import com.ark.identify.application.service.command.SignUpBySmsCommand;
import com.ark.identify.application.service.SignInApplicationService;
import com.ark.identify.application.service.SignUpApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册
 */
@RestController
@RequestMapping("/signup")
public class SignUpController {
    @Autowired
    private SignUpApplicationService signUpApplicationService;
    /**
     * 主动注册
     */
    @PostMapping("sms")
    public Response signUpBySms(@RequestBody SignUpBySmsCommand command) {
        return signUpApplicationService.signUpBySms(command);
    }
}
