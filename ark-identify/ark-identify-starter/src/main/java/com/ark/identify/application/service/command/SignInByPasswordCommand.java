package com.ark.identify.application.service.command;

import com.ark.client.context.ArkContext;
import com.ark.identify.domain.account.entity.Account;
import com.ark.identify.domain.account.entity.valueobject.AccountTenant;
import com.ark.identify.domain.account.entity.valueobject.Password;
import com.google.common.collect.Lists;
import lombok.Data;

@Data
public class SignInByPasswordCommand {
    /**
     * 用户名
     */
    private String account;
    /**
     * 密码
     */
    private String password;


    public Account convetTo() {
        return new Account()
                .setPassword(new Password(password))
                .setTenantList(Lists.newArrayList(new AccountTenant().setTenantId(ArkContext.ACCOUNT_CONTEXT.get().getTenantId())));
    }
}
