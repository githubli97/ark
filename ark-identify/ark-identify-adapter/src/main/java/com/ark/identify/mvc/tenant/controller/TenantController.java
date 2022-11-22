package com.ark.identify.mvc.tenant.controller;


import com.ark.common.dto.Response;
import com.ark.identify.application.service.command.SignInByPhoneCommand;
import com.ark.identify.application.service.TenantApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tenant")
public class TenantController {
    @Autowired
    private TenantApplicationService tenantApplicationService;

    @PostMapping("signUpByPhone")
    public Response<Long> signInByPhone(@RequestBody SignInByPhoneCommand signInByPhoneCommand) {
        return tenantApplicationService.signUpByPhone(signInByPhoneCommand);
    }
}
