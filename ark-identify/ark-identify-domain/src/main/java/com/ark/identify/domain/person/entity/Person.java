package com.ark.identify.domain.person.entity;

import com.ark.base.domain.base.ArkEntity;
import com.ark.base.domain.phone.ChinaPhone;
import com.ark.identify.domain.account.entity.Account;
import com.ark.identify.domain.account.entity.AccountId;
import com.ark.identify.domain.department.Department;
import com.ark.identify.domain.department.DepartmentId;
import lombok.Getter;

/**
 * 用户
 */
@Getter
public class Person extends ArkEntity<Person> {
    private PersonId personId;

    /**
     * 用户真实姓名
     */
    private PersonName personName;

    /**
     * 用户性别
     */
    private PersonSex personSex;

    @Override
    public boolean sameIdentityAs(Person other) {
        return personId.equals(other.getPersonId());
    }
}
