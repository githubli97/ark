package com.ark.identify.domain.account.service.impl;

import com.ark.common.dto.Response;
import com.ark.common.enumerate.ResponseCodeEnum;
import com.ark.identify.domain.account.entity.Account;
import com.ark.identify.domain.account.repository.AccountRepository;
import com.ark.identify.domain.account.service.AccountDomainService;
import com.ark.identify.domain.account.service.AccountFactory;
import com.ark.identify.domain.department.entity.Department;
import com.ark.identify.domain.tenant.entity.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Classname AccountDomainServiceImpl
 * @Description AccountDomainServiceImpl
 * @Date 2022/11/21 20:08
 * @Created by hang.li
 */
@Service
public class AccountDomainServiceImpl implements AccountDomainService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Response<String> signInByPhoneAndPassword(Account account) {
        Optional<Account> optionalAccount = accountRepository.selectByPhoneAndPassword(account.getChinaPhone(), account.getPassword());
        if (optionalAccount.isPresent()) {
            return Response.ok(optionalAccount.get().createSignInToken());
        } else {
            return Response.error(ResponseCodeEnum.PHONE_PASSWORD_AUTH_FAIL);
        }
    }

    @Override
    public Account phoneAccountRegister(Tenant tenant, Department department, String chinaPhone) {
        Account account = AccountFactory.signUpByPhone(tenant, department, chinaPhone);
        return accountRepository.store(account);
    }
}
