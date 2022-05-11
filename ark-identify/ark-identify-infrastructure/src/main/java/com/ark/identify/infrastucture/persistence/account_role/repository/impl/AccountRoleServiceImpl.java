package com.ark.identify.infrastucture.persistence.account_role.repository.impl;

import com.ark.identify.infrastucture.persistence.account_role.model.AccountRolePO;
import com.ark.identify.infrastucture.persistence.account_role.mapper.AccountRoleMapper;
import com.ark.identify.infrastucture.persistence.account_role.repository.IAccountRoleService;
import com.ark.base.service.ArkServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author lihang
 * @since 2022-05-11
 */
@Service
public class AccountRoleServiceImpl extends ArkServiceImpl<AccountRoleMapper, AccountRolePO> implements IAccountRoleService {

}
