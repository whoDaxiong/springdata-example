package com.xyg.service;

import com.xyg.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceTest {
    private ApplicationContext applicationContext = null;
    private EmployeeService employeeService = null;

    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeService = applicationContext.getBean(EmployeeService.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        System.out.println("tearDown");
        applicationContext = null;
    }

    @Test
    public void testUpdate(){
        employeeService.update("zhangsan");
    }

    @Test
    public void testDelete(){
        employeeService.delete("test10");
    }

    @Test
    public void testSave(){
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee();
        employee1.setName("test10");
        employee1.setAge(33);
        Employee employee2 = new Employee();
        employee2.setName("test11");
        employee2.setAge(33);
        employees.add(employee1);
        employees.add(employee2);
        employeeService.save(employees);
    }
}
