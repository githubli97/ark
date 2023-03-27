package com.ark.identify.domain.user;

import com.ark.domain.AbstractNameableEntity;

public class User extends AbstractNameableEntity {
    private Long tenantId;

    @Override
    protected boolean verifyName(String name) {
        return true;
    }
}
