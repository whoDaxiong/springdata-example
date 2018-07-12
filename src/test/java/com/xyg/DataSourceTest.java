package com.xyg;


import com.xyg.dao.StudentDAO;
import com.xyg.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.util.List;

public class DataSourceTest {
    private ApplicationContext applicationContext = null;
    private StudentDAO studentDAO = null;

    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        System.out.println("tearDown");
        applicationContext = null;
    }

    @Test
    public void dataSourceTest(){
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        Assert.notNull(dataSource);
    }

    @Test
    public void JDBCTemplateTest(){
        StudentDAO studentDAO = (StudentDAO) applicationContext.getBean("studentDAO");
        Assert.notNull(studentDAO);
    }

    @Test
    public void testQuery(){
        studentDAO = (StudentDAO) applicationContext.getBean("studentDAO");
//        List<Student> query = studentDAO.query();
//        for (Student s : query) {
//            System.out.println(s);
//        }
        Assert.notNull(studentDAO);
    }

}
