package com.ark.identify.domain.role;

import com.ark.domain.AbstractNameableEntity;

import java.util.List;

public class ResourceType extends AbstractNameableEntity {
    private Long tenantId;


    @Override
    protected boolean verifyName(String name) {
        return true;
    }
}
