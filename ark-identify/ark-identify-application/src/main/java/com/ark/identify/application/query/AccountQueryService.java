package com.ark.identify.application.query;

import com.ark.identify.application.query.dto.AccountDTO;

public interface AccountQueryService {
    AccountDTO getAccountByPhone(String username);
}
