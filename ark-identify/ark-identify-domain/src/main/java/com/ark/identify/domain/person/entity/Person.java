package com.ark.identify.domain.person.entity;

import com.ark.base.domain.base.ArkEntity;
import lombok.Getter;

@Getter
public class Person extends ArkEntity<Person> {

    @Override
    public boolean sameIdentityAs(Person other) {
        return false;
    }
}
