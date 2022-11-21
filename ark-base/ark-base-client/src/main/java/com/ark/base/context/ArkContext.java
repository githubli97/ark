package com.ark.base.context;

public class ArkContext {
    private ArkContext() {
    }

    public static final ThreadLocal<AccountContext> ACCOUNT_CONTEXT = ThreadLocal.withInitial(() -> new AccountContext());
}

