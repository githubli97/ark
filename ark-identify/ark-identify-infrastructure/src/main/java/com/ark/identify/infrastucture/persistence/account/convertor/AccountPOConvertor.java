package com.ark.identify.infrastucture.persistence.account.convertor;

import com.ark.base.convertor.Convertor;
import com.ark.base.domain.phone.ChinaPhone;
import com.ark.identify.domain.account.entity.Account;
import com.ark.identify.domain.account.entity.valueobject.AccountStatus;
import com.ark.identify.domain.account.entity.valueobject.Password;
import com.ark.identify.domain.account.entity.valueobject.UserName;
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
                .setUserName(DO.getUsername().getUserName())
                .setPhoneNumber(DO.getChinaPhone().getPhoneNumber())
                .setAccountStatus(DO.getAccountStatus().getCode());
        return accountPO;
    }

    @Override
    public Account POToDO(AccountPO PO) {
        return new Account()
                .setUsername(new UserName(PO.getUserName()))
                .setPassword(new Password().setPassword(PO.getPassword()))
                .setChinaPhone(new ChinaPhone(PO.getPhoneNumber()))
                .setAccountStatus(AccountStatus.getByCode(PO.getAccountStatus()));
    }
}
