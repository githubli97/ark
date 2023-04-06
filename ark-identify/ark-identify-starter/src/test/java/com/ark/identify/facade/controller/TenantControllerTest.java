package com.ark.identify.facade.controller;

import com.ark.ApplicationTest;
import com.ark.identify.application.service.tenant.command.CreateTenantByPhoneCommand;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import java.util.Random;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * 租户controller测试类.
 */
public class TenantControllerTest extends ApplicationTest {
  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private ObjectMapper objectMapper;
  @Autowired
  private Faker faker;


  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void create() throws Exception {
    CreateTenantByPhoneCommand command = new CreateTenantByPhoneCommand();

    command.setTenantName(faker.company().name());
    command.setPhone(faker.phoneNumber().phoneNumber());
    command.setVerifyCode(faker.currency().code());

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/tenant/phone")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(command))
        )
        .andExpectAll(MockMvcResultMatchers.status().isOk());
  }
}