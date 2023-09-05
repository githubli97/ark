package com.ark.identify.infrastructure.tenant;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 使用jpa实现的租户持久化方法.
 */
@Repository
public interface TenantJpaRepository extends ReactiveCrudRepository<TenantPo, Long> {
}
