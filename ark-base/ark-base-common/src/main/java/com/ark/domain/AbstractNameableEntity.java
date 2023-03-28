package com.ark.domain;

import com.ark.common.exception.ArkRuntimeException;

public abstract class AbstractNameableEntity extends AbstractEntity {
    private String name;

    public String getName() {
        return name;
    };
    protected abstract boolean verifyName(String name);

    public void setName(String name){
        if (verifyName(name)) {
            this.name = name;
            return;
        }
        throw new ArkRuntimeException();
    }
}
