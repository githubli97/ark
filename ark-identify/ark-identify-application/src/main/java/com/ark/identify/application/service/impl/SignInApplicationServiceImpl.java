package com.ark.identify.application.service.impl;

import com.ark.common.dto.Response;
import com.ark.identify.application.service.SignInApplicationService;
import com.ark.identify.application.service.command.SignInByPasswordCommand;
import com.ark.identify.application.service.command.SignInBySmsCommand;
import com.ark.identify.domain.account.entity.Account;
import com.ark.identify.domain.account.service.AccountDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SignInApplicationServiceImpl implements SignInApplicationService {
    @Autowired
    private AccountDomainService accountDomainService;

    @Override
    public Response signInByPassword(Account account) {

        return Response.ok();
    }

    @Override
    public Response signInBySms(SignInBySmsCommand command) {
        return null;
    }
}
