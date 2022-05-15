package com.ark.identify.domain.person.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PersonSex {
    WOMAN(0, "女"), MALE(1, "男");
    private int personSex;
    private String sexName;
}
