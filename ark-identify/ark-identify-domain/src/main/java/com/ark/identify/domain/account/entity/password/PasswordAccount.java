package com.ark.identify.domain.account.entity.password;

import com.ark.identify.domain.account.entity.tenant.TenantAccount;
import com.ark.identify.domain.tenant.entity.TenantId;
import lombok.Getter;

@Getter
public abstract class PasswordAccount extends TenantAccount {
    /**
     * 默认密码
     */
    public static final String DEFAULT_PASSWORD = "qwerasdf!";

    private UserName userName;
    private Password password;

    public PasswordAccount(TenantId tenantId) {
        super(tenantId);
        // 用户名生成器
        this.userName = new UserName("1");
        // 默认 密码
        this.password = new Password(DEFAULT_PASSWORD);
    }

    public void updatePassword(Password password) {
        super.update();
        this.password = password;
    }
}
