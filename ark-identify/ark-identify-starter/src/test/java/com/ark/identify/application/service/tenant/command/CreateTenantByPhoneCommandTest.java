package com.ark.identify.application.service.tenant.command;

import com.ark.ApplicationTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class CreateTenantByPhoneCommandTest extends ApplicationTest {
  @Autowired
  private ObjectMapper objectMapper;
  @Autowired
  private Faker faker;

  @Test
  public void createCase() throws Exception {
    ArrayList<String> caseList = Lists.newArrayListWithExpectedSize(10000);
    caseList.add("数据集名称,phone,tenantName,verifyCode");
    for (int i = 0; i < 10000; i++) {
      StringBuilder sb = new StringBuilder();
      sb.append("数据集-" + i).append(",")
              .append(faker.phoneNumber().phoneNumber()).append(",")
              .append(faker.company().name().replaceAll(",", "")).append(",")
              .append(faker.number().numberBetween(100000, 999999));
      caseList.add(sb.toString());
    }
    caseList.stream().forEach(System.out::println);
  }

}