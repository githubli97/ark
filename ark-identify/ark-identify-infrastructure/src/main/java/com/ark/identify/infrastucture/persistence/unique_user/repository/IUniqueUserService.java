package com.ark.identify.infrastucture.persistence.unique_user.repository;

import com.ark.identify.domain.tenant.repository.TenantRepository;
import com.ark.identify.infrastucture.persistence.unique_user.model.UniqueUserPO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* <p>
    * 唯一用户表，表明账户和租户的关系 服务类
    * </p>
*
* @author lihang
* @since 2022-05-10
*/
public interface IUniqueUserService extends IService<UniqueUserPO> {

}
