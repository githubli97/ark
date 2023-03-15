package com.ark.identify.infrastucture.persistence.unique_user.repository;

import com.ark.identify.domain.account.entity.Account;
import com.ark.identify.infrastucture.persistence.unique_user.model.UniqueUserPO;
import com.ark.identify.infrastucture.persistence.account.model.AccountPO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

/**
* <p>
    * 唯一用户表，表明账户和租户的关系 服务类
    * </p>
*
* @author lihang
* @since 2022-05-10
*/
public interface IUniqueUserService extends IService<UniqueUserPO> {

    @NotNull
    default List<UniqueUserPO> convertUniqueUserPO(Account account, AccountPO accountPO) {
        return account.getTenantList().stream().map(tenant -> {
            UniqueUserPO uniqueUserPO = new UniqueUserPO();
            uniqueUserPO.setTenantId(tenant.getTenantId())
                    .setAccountId(account.getAccountId())
                    .setDepartmentId(tenant.getDepartmentId())
                    .setId(null);
            return uniqueUserPO;
        }).collect(Collectors.toList());
    }

}
