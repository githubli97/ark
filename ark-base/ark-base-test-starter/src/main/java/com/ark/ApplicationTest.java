package com.ark;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * 子类实现后可不用额外添加springboot相关测试注解.
 */
@SpringBootTest
@ContextConfiguration(classes = Application.class)
@AutoConfigureMockMvc
public class ApplicationTest {

}