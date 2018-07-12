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
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class EmployeeJpaSpecigicationExecutorRepositoryTest {
    private ApplicationContext applicationContext = null;
    private EmployeeJpaSpecificationExecutorRepository jpaSpecificationExecutorRepository = null;

    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("beans-new.xml");
        jpaSpecificationExecutorRepository = applicationContext.getBean(EmployeeJpaSpecificationExecutorRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        System.out.println("tearDown");
        applicationContext = null;
    }


    /**
     * 分页+排序+设置查询条件
     */
    @Test
    public void testQuery() {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order);
        Pageable pageable = new PageRequest(0, 5, sort);

        /**
         * root就是要查询的类型（Employee）
         * criteriaQuery:添加查询条件
         * criteriaBuilder：构建Predicate
         */
        Specification<Employee> specification = new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path path = root.get("age");
                Predicate predicate = criteriaBuilder.gt(path, 20);//年龄大于20
                return predicate;
            }
        };

        Page<Employee> page = jpaSpecificationExecutorRepository.findAll(specification,pageable);
        System.out.println("查询总页数："+page.getTotalPages());
        System.out.println("查询当前页数："+page.getNumber()+1);
        System.out.println("查询总记录数："+page.getTotalElements());
        System.out.println("查询当前页集合："+page.getContent());
        System.out.println("查询当前页记录数："+page.getNumberOfElements());
    }

}
