package com.ark.identify.application.tenant.service.impl;

import com.alibaba.fastjson.JSON;
import com.ark.common.util.BeanUtils;
import com.ark.identify.application.tenant.command.SignInByPhoneCommand;
import com.ark.identify.application.tenant.service.TenantApplicationService;
import com.ark.identify.domain.account.PhoneAccountRepository;
import com.ark.identify.domain.account.entity.AccountId;
import com.ark.identify.domain.account.entity.phone.PhoneAccount;
import com.ark.identify.domain.tenant.entity.Tenant;
import com.ark.identify.domain.tenant.entity.TenantId;
import com.ark.identify.domain.tenant.repository.TenantRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TenantApplicationServiceImplMockTest {
    public static TenantApplicationService TENANT_APPLICATION_SERVICE = new TenantApplicationServiceImpl();

    @BeforeAll
    public static void beforeAll() {

        try {
            BeanUtils.setProperty(TENANT_APPLICATION_SERVICE, "tenantRepository", new TenantRepository() {
                @Override
                public Tenant save(Tenant tenant) {
                    try {
                        BeanUtils.setProperty(tenant, "tenantId", new TenantId(12L));
                        System.out.println("保存租户成功" + JSON.toJSONString(tenant));
                    } catch (Exception e) {
                        throw new RuntimeException("初始化失败");
                    }
                    return tenant;
                }
            });
            BeanUtils.setProperty(TENANT_APPLICATION_SERVICE, "phoneAccountRepository", new PhoneAccountRepository() {
                @Override
                public PhoneAccount save(PhoneAccount account) {
                    try {
                        BeanUtils.setProperty(account, "accountId", new AccountId(13L));
                        System.out.println("保存用户成功" + JSON.toJSONString(account));
                    } catch (Exception e) {
                        throw new RuntimeException("初始化失败");
                    }
                    return account;
                }
            });
        } catch (Exception e) {
            throw new RuntimeException("初始化失败");
        }
    }

    @Test
    public void signInByPhone() {
        SignInByPhoneCommand signInByPhoneCommand = new SignInByPhoneCommand();
        signInByPhoneCommand.setPhoneNumber("18888888888");
        signInByPhoneCommand.setTenantName("【方舟】");

        TENANT_APPLICATION_SERVICE.signInByPhone(signInByPhoneCommand);
    }

}
