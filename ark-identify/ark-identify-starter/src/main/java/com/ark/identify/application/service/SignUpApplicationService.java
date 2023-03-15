package com.ark.identify.application.service;

import com.ark.identify.application.service.command.SignUpBySmsCommand;
import com.ark.common.dto.Response;

public interface SignUpApplicationService {
    Response signUpBySms(SignUpBySmsCommand command);
}
