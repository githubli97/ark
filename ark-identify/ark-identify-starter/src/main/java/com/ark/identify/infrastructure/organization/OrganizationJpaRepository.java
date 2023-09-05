package com.ark.identify.infrastructure.organization;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 使用jpa实现的组织持久化方法.
 */
@Repository
public interface OrganizationJpaRepository extends ReactiveCrudRepository<OrganizationPo, Long> {

}
