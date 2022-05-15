package com.ark.identify.domain.person.entity;

import com.ark.common.exception.api.Assert;
import lombok.Getter;

import java.util.Map;

@Getter
public class PersonName {
    private String personName;

    public PersonName(String personName) {
        Assert.inLengthRange(personName, 20, Map.of("personName", "姓名字数在20个内"));
        this.personName = personName;
    }
}
