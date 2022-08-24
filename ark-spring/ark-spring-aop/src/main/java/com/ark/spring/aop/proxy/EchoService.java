package com.ark.spring.aop.proxy;

import java.util.Random;

public interface EchoService {
    void print(String str);
    void printRandomException(String str);
}