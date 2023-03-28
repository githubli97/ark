package com.ark.identify.domain.role;

import com.ark.domain.AbstractNameableEntity;

public class ResourceType extends AbstractNameableEntity {
    private Long tenantId;


    @Override
    protected void assertVerifyName(String name) {
    }
}
