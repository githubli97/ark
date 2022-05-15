package com.ark.identify.domain.person.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class PersonId {
    private Long personId;

    public PersonId(Long personId) {
        this.personId = personId;
    }
}
