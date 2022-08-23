package com.ark.base.myspringtest.aop.proxy;

public class NoImplementsEchoServiceImpl {
    public void print(String str) {
        System.out.printf("[NoImplementsEchoServiceImpl]" + str);
    }
}