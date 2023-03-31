package com.ark.identify.infrastructure.tenant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantJpaRepository extends JpaRepository<TenantPO, Long> {

}
