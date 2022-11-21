package com.ark.identify.application.service.impl;

import com.ark.common.dto.Response;
import com.ark.identify.application.service.SignInApplicationService;
import com.ark.identify.application.service.command.SignInByPasswordCommand;
import com.ark.identify.application.service.command.SignInBySmsCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SignInApplicationServiceImpl implements SignInApplicationService {

    @Override
    public Response signInByPassword(SignInByPasswordCommand command) {
        return Response.ok();
    }

    @Override
    public Response signInBySms(SignInBySmsCommand command) {
        return null;
    }
}
