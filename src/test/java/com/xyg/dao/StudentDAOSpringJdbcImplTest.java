package com.xyg.dao;

import com.xyg.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class StudentDAOSpringJdbcImplTest {

    private ApplicationContext applicationContext = null;
    private StudentDAO studentDAO = null;

    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        studentDAO = (StudentDAO) applicationContext.getBean("studentDAO");
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        System.out.println("tearDown");
        applicationContext = null;
    }

    @Test
    public void testQuery(){
        List<Student> query = studentDAO.query();
        for (Student s : query) {
            System.out.println(s);
        }
    }

    @Test
    public void testSave(){
        Student student = new Student();
        student.setName("ft");
        student.setAge(22);
        studentDAO.save(student);
    }
}
