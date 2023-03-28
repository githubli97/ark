package com.ark.identify.domain.organiztion;

import com.ark.domain.AbstractNameableEntity;

public class Organiztion extends AbstractNameableEntity {
    private Employee manager;

    @Override
    protected void assertVerifyName(String name) {
    }
}
