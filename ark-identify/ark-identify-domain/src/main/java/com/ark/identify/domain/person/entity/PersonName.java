package com.ark.identify.domain.person.entity;

import com.ark.common.exception.api.Assert;
import com.ark.common.util.MapUtil;
import lombok.Getter;

import java.util.Map;

@Getter
public class PersonName {
    private String personName;

    public PersonName(String personName) {
        Assert.inLengthRange(personName, 20, MapUtil.simpleMap("personName", "姓名字数在20个内"));
        this.personName = personName;
    }
}
