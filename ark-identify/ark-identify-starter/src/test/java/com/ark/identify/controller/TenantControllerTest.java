package com.ark.identify.controller;

import com.ark.ApplicationTest;
import com.ark.identify.application.service.command.SignInByPhoneCommand;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * TenantController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>5月 10, 2022</pre>
 */
@Slf4j
public class TenantControllerTest extends ApplicationTest {

    @Autowired
    private MockMvc mvc;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: signInByPhone(SignInByPhoneCommand signInByPhoneCommand)
     */
    @Test
    public void testSignInByPhone() throws Exception {
        SignInByPhoneCommand signInByPhoneCommand = new SignInByPhoneCommand()
                .setPhoneNumber("18888888888")
                .setTenantName("【方舟3】");
        mvc.perform(MockMvcRequestBuilders
                .post("/tenant/signUpByPhone")
                .content(new ObjectMapper().writeValueAsString(signInByPhoneCommand))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(result -> {
                    log.info("{}", result.getResponse().getContentAsString());
                });
    }


} 
