package com.ark.identify.infrastucture.persistence.account.repository.impl;

import com.ark.base.convertor.Convertor;
import com.ark.base.domain.phone.ChinaPhone;
import com.ark.base.service.ArkServiceImpl;
import com.ark.identify.domain.account.entity.Account;
import com.ark.identify.domain.account.entity.valueobject.Password;
import com.ark.identify.infrastucture.persistence.account.mapper.AccountMapper;
import com.ark.identify.infrastucture.persistence.account.model.AccountPO;
import com.ark.identify.infrastucture.persistence.account.repository.IAccountService;
import com.ark.identify.infrastucture.persistence.unique_user.model.UniqueUserPO;
import com.ark.identify.infrastucture.persistence.unique_user.repository.IUniqueUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    private Convertor<Account, AccountPO> convertor;
    @Autowired
    private IUniqueUserService iUniqueUserService;

    @Override
    public Account store(Account entiy) {
        AccountPO accountPO = convertor.DOToPO(entiy);
        this.save(accountPO);
        entiy.setAccountId(accountPO.getId());

        List<UniqueUserPO> uniqueUserPOList = iUniqueUserService.convertUniqueUserPO(entiy, accountPO);
        iUniqueUserService.saveBatch(uniqueUserPOList);

        return entiy;
    }

    @Override
    public Optional<Account> selectByPhoneAndPassword(ChinaPhone phone, Password password) {
        return Optional.empty();
    }
}
