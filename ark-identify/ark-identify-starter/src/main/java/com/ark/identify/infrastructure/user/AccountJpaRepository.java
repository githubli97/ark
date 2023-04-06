package com.ark.identify.infrastructure.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 使用jpa实现的登录方式持久化方法.
 */
@Repository
public interface AccountJpaRepository extends JpaRepository<AccountPo, Long> {

}
