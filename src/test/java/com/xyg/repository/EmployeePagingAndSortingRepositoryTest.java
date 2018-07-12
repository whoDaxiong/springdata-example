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
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeePagingAndSortingRepositoryTest {
    private ApplicationContext applicationContext = null;
    private PagingAndSortingRepository pagingAndSortingRepository= null;

    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("beans-new.xml");
        pagingAndSortingRepository = applicationContext.getBean(PagingAndSortingRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        System.out.println("tearDown");
        applicationContext = null;
    }

    @Test
    public void testPage(){
        Pageable pageable = new PageRequest(0, 5);
        Page<Employee> page = pagingAndSortingRepository.findAll(pageable);
        System.out.println("查询总页数："+page.getTotalPages());
        System.out.println("查询当前页数："+page.getNumber()+1);
        System.out.println("查询总记录数："+page.getTotalElements());
        System.out.println("查询当前页集合："+page.getContent());
        System.out.println("查询当前页记录数："+page.getNumberOfElements());
    }

    @Test
    public void testPageAndSort(){
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order);
        Pageable pageable = new PageRequest(0, 5, sort);
        Page<Employee> page = pagingAndSortingRepository.findAll(pageable);
        System.out.println("查询总页数："+page.getTotalPages());
        System.out.println("查询当前页数："+page.getNumber()+1);
        System.out.println("查询总记录数："+page.getTotalElements());
        System.out.println("查询当前页集合："+page.getContent());
        System.out.println("查询当前页记录数："+page.getNumberOfElements());
    }
}
