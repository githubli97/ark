package com.ark.identify.infrastructure.organization;

import com.ark.identify.domain.organiztion.Organization;
import com.ark.identify.domain.organiztion.OrganizationRepository;
import com.ark.infrastructure.base.RepositoryImpl;
import org.springframework.stereotype.Service;

/**
 * Repository 基类.
 */
@Service
public class OrganizationRepositoryImpl extends RepositoryImpl<Organization, OrganizationPo>
    implements OrganizationRepository {

}
