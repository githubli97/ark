package com.ark.identify.infrastucture.persistence.account.repository.impl;

import com.ark.ApplicationTest;
import com.ark.base.domain.phone.ChinaPhone;
import com.ark.identify.domain.account.entity.phone.PhoneAccount;
import com.ark.identify.domain.tenant.entity.TenantId;
import com.ark.identify.infrastucture.persistence.account.repository.IAccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * AccountServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>5月 9, 2022</pre>
 */
public class AccountServiceImplTest extends ApplicationTest {
    @Autowired
    private IAccountService accountService;

    /**
     * Method: store(PhoneAccount baseTrace)
     */
    @Test
    public void testStore() throws Exception {
        PhoneAccount phoneAccount = PhoneAccount.phoneAccountRegister(new TenantId(1L), new ChinaPhone("18888888888"));

        accountService.store(phoneAccount);
    }

    /**
     * Method: getOperatorId()
     */
    @Test
    public void testGetOperatorId() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: isBaseTrace()
     */
    @Test
    public void testIsBaseTrace() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: isInsert(PhoneAccount trace)
     */
    @Test
    public void testIsInsert() throws Exception {
        //TODO: Test goes here...
    }


} 
