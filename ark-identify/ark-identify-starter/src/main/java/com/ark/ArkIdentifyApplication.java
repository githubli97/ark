package com.ark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 认证中心启动引导类.
 */
@SpringBootApplication
//@EnableFeignClients(basePackages = {"com.ark.userinfo.query"})
public class ArkIdentifyApplication {

  public static void main(String[] args) {
    SpringApplication.run(ArkIdentifyApplication.class, args);
  }
}