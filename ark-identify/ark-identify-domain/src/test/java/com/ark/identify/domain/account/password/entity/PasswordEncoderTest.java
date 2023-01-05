package com.ark.identify.domain.account.password.entity;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
public class PasswordEncoderTest {

    public static final BCryptPasswordEncoder BCRYPT_PASSWORD_ENCODER = new BCryptPasswordEncoder();

    public static final String SOURCE_PASSWORD = "openid-connect";
    /**
     * 正常修改
     */
    @Test
    public void testEncode() {
        String password = BCRYPT_PASSWORD_ENCODER.encode(SOURCE_PASSWORD);
        System.out.print("加密后： ");
        System.out.println(password);
    }
    @Test
    public void testMatch() {
        String password = BCRYPT_PASSWORD_ENCODER.encode(SOURCE_PASSWORD);
        System.out.print("加密后： ");
        System.out.println(password);
        System.out.println(BCRYPT_PASSWORD_ENCODER.matches(SOURCE_PASSWORD, password));
    }
}
