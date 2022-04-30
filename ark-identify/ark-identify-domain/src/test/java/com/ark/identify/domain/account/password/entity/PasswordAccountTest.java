package com.ark.identify.domain.account.password.entity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PasswordAccountTest {

    /**
     * 正常修改
     */
//    @Test
//    public void updatePassword() {
//        String newPassword = "newPassword";
//        PasswordAccount passwordAccount = new PasswordAccount(new TenantId(1L));
//        passwordAccount.updatePassword(new Password(newPassword));
//        Assert.equals(newPassword, passwordAccount.getPassword().getPassword());
//    }
//    /**
//     * 密码非法
//     */
//    @Test
//    public void updatePasswordInvalid() {
//        String newPassword = "";
//        PasswordAccount passwordAccount = new PasswordAccount(new TenantId(1L));
//
//        try {
//            passwordAccount.updatePassword(new Password(newPassword));
//        } catch (ArkAttributeInvaildException e) {
//            log.error("{}", e.getResponse(), e);
//        }
//    }
//    /**
//     * 账户禁用
//     */
//    @Test
//    public void updatePasswordAccountDisable() {
//        String newPassword = "newPassword";
//        PasswordAccount passwordAccount = new PasswordAccount(new TenantId(1L));
//        passwordAccount.disable();
//        try {
//            passwordAccount.updatePassword(new Password(newPassword));
//        } catch (ArkServiceException e) {
//            log.error("{}", e.getResponse(), e);
//        }
//    }
}
