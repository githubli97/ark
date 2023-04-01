package com.ark.identify.infrastructure.tenant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 使用jpa实现的租户持久化方法.
 */
@Repository
public interface TenantJpaRepository extends JpaRepository<TenantPo, Long> {

}
