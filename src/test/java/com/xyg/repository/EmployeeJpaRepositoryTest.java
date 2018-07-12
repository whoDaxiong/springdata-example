package com.xyg.repository;

import com.xyg.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public class EmployeeJpaRepositoryTest {
    private ApplicationContext applicationContext = null;
    private JpaRepository jpaRepository= null;

    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("beans-new.xml");
        jpaRepository = applicationContext.getBean(JpaRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        System.out.println("tearDown");
        applicationContext = null;
    }

    @Test
    public void FindOne() {
        Employee employee = (Employee) jpaRepository.findOne(13);
        System.out.println(employee);
    }
}
