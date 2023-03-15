package com.ark.client.context;

public class ArkContext {
    private ArkContext() {
    }

    public static final ThreadLocal<AccountContext> ACCOUNT_CONTEXT = ThreadLocal.withInitial(() -> new AccountContext());
}

