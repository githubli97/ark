package com.ark.identify.domain.tenant;

import com.ark.domain.AbstractNameableEntity;

public class Tenant extends AbstractNameableEntity {

    @Override
    protected boolean verifyName(String name) {
        return true;
    }
}
