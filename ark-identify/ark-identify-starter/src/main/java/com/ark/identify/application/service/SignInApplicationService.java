package com.ark.identify.application.service;

import com.ark.identify.application.service.command.SignInBySmsCommand;
import com.ark.identify.domain.account.entity.Account;
import com.ark.common.dto.Response;

public interface SignInApplicationService {
    Response signInByPassword(Account account);

    Response signInBySms(SignInBySmsCommand command);
}
