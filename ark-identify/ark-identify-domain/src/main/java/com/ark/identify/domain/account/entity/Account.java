package com.ark.identify.domain.account.entity;

import com.ark.base.domain.base.ArkEntity;
import com.ark.common.exception.api.Assert;
import lombok.Getter;

@Getter
public class Account extends ArkEntity<Account> {
    private AccountId accountId;
    private AccountStatus accountStatus;

    public Account() {
        this.accountStatus = AccountStatus.Enable;
    }

    /**
     * 账户修改操作统一校验status
     * 状态为禁用时，不允许修改操作
     */
    public void update() {
        Assert.serviceInvaild(AccountStatus.DISABLE.equals(accountStatus), "账户禁用，不允许修改");
    }

    /**
     * 账户禁用
     */
    public void disable() {
        Assert.serviceInvaild(AccountStatus.DISABLE.equals(accountStatus), "账户已经在禁用用状态");
        this.accountStatus = AccountStatus.DISABLE;
    }

    /**
     * 账户启用
     */
    public void enable() {
        Assert.serviceInvaild(AccountStatus.Enable.equals(accountStatus), "账户已经在启用状态");
        this.accountStatus = AccountStatus.Enable;
    }

    protected void setAccountId(AccountId accountId) {
        this.accountId = accountId;
    }

    protected void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public boolean sameIdentityAs(Account other) {
        return accountId.equals(other.getAccountId());
    }
}
