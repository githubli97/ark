package com.ark.spring.aop.proxy;

import java.util.Random;

public class NoImplementsEchoServiceImpl {
    public void print(String str) {
        System.out.printf("[NoImplementsEchoServiceImpl] " + str + "\n");
    }
    public void printRandomException(String str) {
        if (new Random().nextBoolean()) {
            int i = 1 / 0;
        }
        System.out.printf("[NoImplementsEchoServiceImpl] " + str + "\n");
    }

    public void printThrowsException(String str) throws Exception {
        System.out.printf("[NoImplementsEchoServiceImpl] " + str + "\n");
    }

    public void concatPrint(String str1, String str2) throws Exception {
        System.out.printf("[NoImplementsEchoServiceImpl] " + str1 + " " + str2 + "\n");
    }
}