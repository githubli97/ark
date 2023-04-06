package com.ark.config;

import com.github.javafaker.Faker;
import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置faker.
 */
@Configuration
public class FakerAutoConfiguration {
  @Bean
  public Faker faker() {
    return new Faker(new Locale("zh-CN"));
  }
}
