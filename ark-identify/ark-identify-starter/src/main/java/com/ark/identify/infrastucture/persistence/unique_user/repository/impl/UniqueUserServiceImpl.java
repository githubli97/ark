package com.ark.identify.infrastucture.persistence.unique_user.repository.impl;

import com.ark.identify.infrastucture.persistence.unique_user.model.UniqueUserPO;
import com.ark.identify.infrastucture.persistence.unique_user.repository.IUniqueUserService;
import com.ark.identify.infrastucture.persistence.unique_user.mapper.UniqueUserMapper;
import com.ark.infrastructure.service.ArkServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 唯一用户表，表明账户和租户的关系 服务实现类
 * </p>
 *
 * @author lihang
 * @since 2022-05-10
 */
@Service
public class UniqueUserServiceImpl extends ArkServiceImpl<UniqueUserMapper, UniqueUserPO> implements IUniqueUserService {

}
