package com.xyg;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDataTest {
    private ApplicationContext applicationContext = null;

    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("beans-new.xml");
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        System.out.println("tearDown");
        applicationContext = null;
    }

    @Test
    public void testEntityManagerFactory() {

    }
}
