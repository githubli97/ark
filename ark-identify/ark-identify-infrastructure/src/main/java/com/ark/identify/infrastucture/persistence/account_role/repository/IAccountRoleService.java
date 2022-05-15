package com.ark.identify.infrastucture.persistence.account_role.repository;

import com.ark.common.util.BeanUtils;
import com.ark.identify.domain.account.entity.PhoneAccount;
import com.ark.identify.infrastucture.persistence.account.model.AccountPO;
import com.ark.identify.infrastucture.persistence.account_role.model.AccountRolePO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

/**
* <p>
    * 用户角色表 服务类
    * </p>
*
* @author lihang
* @since 2022-05-11
*/
public interface IAccountRoleService extends IService<AccountRolePO> {
    @NotNull
    default List<AccountRolePO> convertAccountRolePO(PhoneAccount baseTrace, AccountPO accountPO) {
        return baseTrace.getRoleList().stream().map(role -> {
            AccountRolePO accountRolePO = new AccountRolePO();
            BeanUtils.copyProperties(accountPO, accountRolePO);
            accountRolePO.setAccountId(accountPO.getId())
                    .setTenantId(role.getTenantId().getTenantId())
                    .setRoleId(role.getRoleId().getRoleId())
                    .setId(null);
            return accountRolePO;
        }).collect(Collectors.toList());
    }

}
