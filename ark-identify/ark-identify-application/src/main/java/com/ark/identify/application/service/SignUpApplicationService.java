package com.ark.identify.application.service;

import com.ark.common.dto.Response;
import com.ark.identify.application.service.command.SignUpBySmsCommand;

public interface SignUpApplicationService {
    Response signUpBySms(SignUpBySmsCommand command);
}
