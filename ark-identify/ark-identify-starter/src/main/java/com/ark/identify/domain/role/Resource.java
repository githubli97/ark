package com.ark.identify.domain.role;

import com.ark.domain.AbstractNameableEntity;

public abstract class Resource extends AbstractNameableEntity {
    private Long tenantId;
    private ResourceType resourceType;
}
