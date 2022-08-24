package com.ark.spring.aop.proxy;

import java.util.Random;

public class DefaultEchoServiceImpl implements EchoService {
    @Override
    public void print(String str) {
        System.out.printf(str);
    }

    @Override
    public void printRandomException(String str) {
        if (new Random().nextBoolean()) {
            int i = 1 / 0;
        }
        System.out.printf("[NoImplementsEchoServiceImpl] " + str + "\n");
    }
}