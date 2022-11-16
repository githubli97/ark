package com.ark.identify.application.service.impl;

import com.ark.common.dto.Response;
import com.ark.identify.application.service.SignInApplicationService;
import com.ark.identify.application.service.command.SignInByPasswordCommand;
import com.ark.identify.application.service.command.SignInBySmsCommand;
import org.springframework.stereotype.Service;

@Service
public class SignInApplicationServiceImpl implements SignInApplicationService {

    @Override
    public Response signInByPassword(SignInByPasswordCommand command) {
        return null;
    }

    @Override
    public Response signInBySms(SignInBySmsCommand command) {
        return null;
    }
}
