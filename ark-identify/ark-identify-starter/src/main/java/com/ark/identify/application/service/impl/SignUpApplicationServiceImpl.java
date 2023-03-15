package com.ark.identify.application.service.impl;

import com.ark.identify.application.service.command.SignUpBySmsCommand;
import com.ark.common.dto.Response;
import com.ark.identify.application.service.SignUpApplicationService;
import org.springframework.stereotype.Service;

@Service
public class SignUpApplicationServiceImpl implements SignUpApplicationService {
    @Override
    public Response signUpBySms(SignUpBySmsCommand command) {
        return Response.ok();
    }
}
