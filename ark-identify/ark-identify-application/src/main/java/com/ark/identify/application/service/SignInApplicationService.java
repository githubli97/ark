package com.ark.identify.application.service;

import com.ark.common.dto.Response;
import com.ark.identify.application.service.command.SignInByPasswordCommand;
import com.ark.identify.application.service.command.SignInBySmsCommand;

public interface SignInApplicationService {
    Response signInByPassword(SignInByPasswordCommand command);

    Response signInBySms(SignInBySmsCommand command);
}
