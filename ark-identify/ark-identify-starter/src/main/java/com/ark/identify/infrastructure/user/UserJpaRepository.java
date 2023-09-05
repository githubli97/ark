package com.ark.identify.infrastructure.user;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 使用jpa实现的用户持久化方法.
 */
@Repository
public interface UserJpaRepository extends ReactiveCrudRepository<UserPo, Long> {
}
