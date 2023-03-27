package com.ark.identify.domain.tenant;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TenantService {
    private ITenantRepository iTenantRepository;
    public void save(Tenant tenant) {
//        iTenantRepository.save(tenant);
    }
}
