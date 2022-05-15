package com.ark.identify.infrastucture.persistence.account.repository.impl;

import com.ark.base.convertor.Convertor;
import com.ark.base.domain.trace.OperatorId;
import com.ark.base.service.ArkServiceImpl;
import com.ark.common.util.BeanUtils;
import com.ark.identify.domain.account.entity.PhoneAccount;
import com.ark.identify.domain.role.entity.Role;
import com.ark.identify.domain.tenant.entity.TenantId;
import com.ark.identify.infrastucture.persistence.account.mapper.AccountMapper;
import com.ark.identify.infrastucture.persistence.account.model.AccountPO;
import com.ark.identify.infrastucture.persistence.account.repository.IAccountService;
import com.ark.identify.infrastucture.persistence.account_role.model.AccountRolePO;
import com.ark.identify.infrastucture.persistence.account_role.repository.IAccountRoleService;
import com.ark.identify.infrastucture.persistence.unique_user.model.UniqueUserPO;
import com.ark.identify.infrastucture.persistence.unique_user.repository.IUniqueUserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    @Autowired
    private IUniqueUserService iUniqueUserService;
    @Autowired
    private IAccountRoleService iAccountRoleService;


    @Override
    public void doStore(PhoneAccount baseTrace) {
        AccountPO accountPO = convertor.DOToPO(baseTrace);
        saveOrUpdate(accountPO);

        List<UniqueUserPO> uniqueUserPOList = iUniqueUserService.convertUniqueUserPO(baseTrace, accountPO);
        iUniqueUserService.saveBatch(uniqueUserPOList);

        List<AccountRolePO> accountRolePOList = iAccountRoleService.convertAccountRolePO(baseTrace, accountPO);
        iAccountRoleService.saveBatch(accountRolePOList);
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
