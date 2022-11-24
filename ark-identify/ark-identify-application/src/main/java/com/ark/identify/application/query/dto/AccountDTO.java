package com.ark.identify.application.query.dto;

import com.ark.identify.infrastucture.persistence.account.model.AccountPO;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @Classname AccountDTO
 * @Description AccountDTO
 * @Date 2022/11/24 9:37
 * @Created by hang.li
 */
@Data
public class AccountDTO {
    private String username;
    private String password;
    private List<String> authorityList;

    public static AccountDTO convertThis(AccountPO accountPO) {
        return new AccountDTO()
                .setUsername(accountPO.getPhoneNumber())
                .setPassword(accountPO.getPassword())
                .setAuthorityList(Lists.newArrayList());
    }
}
