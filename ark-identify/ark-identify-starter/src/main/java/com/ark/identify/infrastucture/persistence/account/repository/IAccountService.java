package com.ark.identify.infrastucture.persistence.account.repository;

import com.ark.identify.domain.account.repository.AccountRepository;
import com.ark.identify.infrastucture.persistence.account.model.AccountPO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lihang
 * @since 2022-05-09
 */
public interface IAccountService extends AccountRepository {

    AccountPO selectByPhone(String phone);
}
