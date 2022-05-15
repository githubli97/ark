package com.ark.identify.infrastucture.persistence.unique_user.repository;

import com.ark.common.util.BeanUtils;
import com.ark.identify.domain.account.entity.PhoneAccount;
import com.ark.identify.domain.tenant.entity.TenantId;
import com.ark.identify.domain.tenant.repository.TenantRepository;
import com.ark.identify.infrastucture.persistence.account.model.AccountPO;
import com.ark.identify.infrastucture.persistence.unique_user.model.UniqueUserPO;
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
    default List<UniqueUserPO> convertUniqueUserPO(PhoneAccount baseTrace, AccountPO accountPO) {
        return baseTrace.getTenantIdList().stream().map(tenantId -> {
            UniqueUserPO uniqueUserPO = new UniqueUserPO();
            BeanUtils.copyProperties(accountPO, uniqueUserPO);
            uniqueUserPO.setTenantId(tenantId.getTenantId())
                    .setAccountId(accountPO.getId())
                    .setDepartmentId(baseTrace.getDepartmentId().getDepartmentId())
                    .setId(null);
            return uniqueUserPO;
        }).collect(Collectors.toList());
    }

}
