package com.ark.common.util; 

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.time.LocalDateTime;

/** 
* BeanUtils Tester. 
* 
* @author <Authors name> 
* @since <pre>5月 11, 2022</pre> 
* @version 1.0 
*/
@Slf4j
public class BeanUtilsTest { 

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
    * @see com.ark.common.util.BeanUtils#setProperty(Object bean, String fieldName, Object depend)
    * Method: setProperty(Object bean, String fieldName, Object depend) 
    * 
    */ 
    @Test
    public void testSetProperty() throws Exception { 
        //TODO: Test goes here... 
    } 

    /** 
    * @see com.ark.common.util.BeanUtils#copyProperties(Object source, Object target)
    * Method: copyProperties(Object source, Object target) 
    * 
    */ 
    @Test
    public void testCopyProperties() throws Exception {
        A a = new A();
        B b = new B();
        BeanUtils.copyProperties(a, b);
        log.info("{}", b);
    }

    @Data
    class A {

        /**
         * 创建人
         */
        private Long creater = 1L;

        /**
         * 创建时间
         */
        private LocalDateTime createTime = LocalDateTime.now();

        /**
         * 修改人
         */
        private Long modifier = 1L;

        /**
         * 修改时间
         */
        private LocalDateTime modifyTime= LocalDateTime.now();
    }
    @Data
    class B {

        /**
         * 创建人
         */
        private Long creater;

        /**
         * 创建时间
         */
        private LocalDateTime createTime;

        /**
         * 修改人
         */
        private Long modifier;

        /**
         * 修改时间
         */
        private LocalDateTime modifyTime;
    }


} 
