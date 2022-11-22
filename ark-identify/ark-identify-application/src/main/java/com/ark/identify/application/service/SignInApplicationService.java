package com.ark.identify.application.service;

import com.ark.common.dto.Response;
import com.ark.identify.application.service.command.SignInByPasswordCommand;
import com.ark.identify.application.service.command.SignInBySmsCommand;
import com.ark.identify.domain.account.entity.Account;

public interface SignInApplicationService {
    Response signInByPassword(Account account);

    Response signInBySms(SignInBySmsCommand command);
}
