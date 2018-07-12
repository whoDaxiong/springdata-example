package com.xyg.repository;

import com.xyg.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryTest {
    private ApplicationContext applicationContext = null;
    private EmployeeRepository employeeRepository = null;

    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeRepository = applicationContext.getBean(EmployeeRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        System.out.println("tearDown");
        applicationContext = null;
    }

    @Test
    public void testFindByName() {
        Employee employee = employeeRepository.findByName("zhangsan");
        System.out.println(employee);
    }

    @Test
    public void testFindByNameAndAge() {
        List<Employee> employees = employeeRepository.findByNameStartingWithAndAgeLessThan("test", 10);
        for (Employee employee:employees
             ) {
            System.out.println(employee);
        }
    }

    @Test
    public void testFindByAge() {
        List<Employee> employees = employeeRepository.findByNameEndingWithAndAgeEquals("san", 32);
        for (Employee employee:employees
                ) {
            System.out.println(employee);
        }
    }

    @Test
    public void testFindByNameIn() {
        List<String> names = new ArrayList<>();
        names.add("test3");
        names.add("test9");
        List<Employee> employees = employeeRepository.findByNameInOrAgeLessThan(names, 10);
        for (Employee employee:employees
                ) {
            System.out.println(employee);
        }
    }

    @Test
    public void testFindById() {
        Employee employeeByIdMax = employeeRepository.getEmployeeByIdMax();
        System.out.println(employeeByIdMax);
    }

    @Test
    public void testgetByNameAndAge() {
        List<Employee> employees = employeeRepository.getByNameAndAge("test1",23);
        for (Employee employee:employees
                ) {
            System.out.println(employee);
        }
    }

    @Test
    public void testgetByNameAndAge2() {
        List<Employee> employees = employeeRepository.getByNameAndAge2("zhangsan",32);
        for (Employee employee:employees
                ) {
            System.out.println(employee);
        }
    }

    @Test
    public void testgetLikeName() {
        List<Employee> employees = employeeRepository.getLikeName("test1");
        for (Employee employee:employees
                ) {
            System.out.println(employee);
        }
    }

    @Test
    public void testGetCount(){
        Long count = employeeRepository.getCount();
        System.out.println(count);
    }
}
