package com.ark.base.myspringtest.aop.proxy;

public class DefaultEchoServiceImpl implements EchoService {
    @Override
    public void print(String str) {
        System.out.printf(str);
    }
}