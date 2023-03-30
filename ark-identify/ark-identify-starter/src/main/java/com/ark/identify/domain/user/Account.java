package com.ark.identify.domain.user;

import com.ark.domain.AbstractEntity;
import com.ark.identify.domain.user.valueobject.AccountTypeEnum;

public class Account extends AbstractEntity {

    private String username;
    private AccountTypeEnum accountType;
    private String password;
    private User user;
}
