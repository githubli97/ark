package com.ark.identify.mvc.tenant.controller;

import com.alibaba.fastjson.JSON;
import com.ark.ApplicationTest;
import com.ark.identify.application.service.command.SignInByPasswordCommand;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * SignInController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>5月 10, 2022</pre>
 */
@Slf4j
public class SignInControllerTest extends ApplicationTest {

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
    public void testSignInByPassword() throws Exception {
        SignInByPasswordCommand command = new SignInByPasswordCommand()
                .setPassword("qwerasdf!")
                .setAccount("18888888888");
        mvc.perform(MockMvcRequestBuilders
                .post("/signin/0/password")
                .content(JSON.toJSONString(command))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(result -> {
                    log.info("{}", result.getResponse().getContentAsString());
                });
    }


} 
