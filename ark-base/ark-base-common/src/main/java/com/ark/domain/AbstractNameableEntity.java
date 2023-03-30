package com.ark.domain;

public abstract class AbstractNameableEntity extends AbstractEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        assertVerifyName(name);
        this.name = name;
    }

    protected abstract void assertVerifyName(String name);
}
