package com.ark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 测试模块使用
 * 目的是引入scanBasePackages.
 */
@SpringBootApplication(scanBasePackages = "com.ark")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}