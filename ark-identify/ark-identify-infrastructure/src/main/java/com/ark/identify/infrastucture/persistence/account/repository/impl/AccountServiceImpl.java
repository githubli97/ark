package com.ark.identify.infrastucture.persistence.account.repository.impl;

import com.ark.base.convertor.Convertor;
import com.ark.base.domain.trace.OperatorId;
import com.ark.base.service.ArkServiceImpl;
import com.ark.identify.domain.account.entity.phone.PhoneAccount;
import com.ark.identify.infrastucture.persistence.account.mapper.AccountMapper;
import com.ark.identify.infrastucture.persistence.account.model.AccountPO;
import com.ark.identify.infrastucture.persistence.account.repository.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lihang
 * @since 2022-05-09
 */
@Service
public class AccountServiceImpl extends ArkServiceImpl<AccountMapper, AccountPO> implements IAccountService {
    @Autowired
    private Convertor<PhoneAccount, AccountPO> convertor;

    @Override
    public void doStore(PhoneAccount baseTrace) {
        AccountPO accountPO = convertor.DOToPO(baseTrace);
        saveOrUpdate(accountPO);
    }

    @Override
    public OperatorId getOperatorId() {
        return new OperatorId("1");
    }

    @Override
    public boolean isBaseTrace() {
        return true;
    }

    @Override
    public boolean isInsert(PhoneAccount trace) {
        return Objects.isNull(trace.getAccountId());
    }
}
