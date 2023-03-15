package com.ark.identify.infrastucture.persistence.account.repository.impl;

import com.ark.infrastructure.convertor.Convertor;
import com.ark.infrastructure.service.ArkServiceImpl;
import com.ark.identify.domain.account.entity.Account;
import com.ark.identify.infrastucture.persistence.account.repository.IAccountService;
import com.ark.identify.infrastucture.persistence.unique_user.model.UniqueUserPO;
import com.ark.identify.infrastucture.persistence.account.mapper.AccountMapper;
import com.ark.identify.infrastucture.persistence.account.model.AccountPO;
import com.ark.identify.infrastucture.persistence.unique_user.repository.IUniqueUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Account getByPhone(String phone) {
        AccountPO accountPO = this.getOne(new LambdaQueryWrapper<AccountPO>()
                .eq(AccountPO::getPhoneNumber, phone));
        return convertor.POToDO(accountPO);
    }

    @Override
    public AccountPO selectByPhone(String phone) {
        return this.getOne(new LambdaQueryWrapper<AccountPO>()
                .eq(AccountPO::getPhoneNumber, phone));
    }
}
