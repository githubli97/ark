package com.ark.identify.infrastucture.persistence.account.convertor;

import com.ark.base.convertor.Convertor;
import com.ark.identify.domain.account.entity.Account;
import com.ark.identify.infrastucture.persistence.account.model.AccountPO;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author lihang
 * @since 2022-05-09
 */
@Component
public class AccountPOConvertor implements Convertor<Account, AccountPO> {
    @Override
    public AccountPO DOToPO(Account DO) {
        AccountPO accountPO = new AccountPO()
                .setPassword(DO.getPassword().getPassword())
                .setPhoneNumber(DO.getChinaPhone().getPhoneNumber())
                .setAccountStatus(DO.getAccountStatus().getCode());
        return accountPO;
    }
}
