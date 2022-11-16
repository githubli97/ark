package com.ark.identify.mvc.tenant.controller;


import com.ark.common.dto.Response;
import com.ark.identify.application.tenant.command.SignInByPhoneCommand;
import com.ark.identify.application.tenant.service.TenantApplicationService;
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

    @PostMapping("signInByPhone")
    public Response<Long> signInByPhone(@RequestBody SignInByPhoneCommand signInByPhoneCommand) {
        return tenantApplicationService.signInByPhone(signInByPhoneCommand);
    }

}
