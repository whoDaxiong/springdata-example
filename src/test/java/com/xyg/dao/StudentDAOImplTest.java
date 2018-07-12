package com.xyg.dao;

import com.xyg.domain.Student;
import org.junit.Test;

import java.util.List;

public class StudentDAOImplTest {

    @Test
    public void testQuery(){
        StudentDAO studentDAO = new StudentDAOImpl();
        List<Student> query = studentDAO.query();
        for (Student s : query) {
            System.out.println(s);
        }
    }

    @Test
    public void testSave(){
        StudentDAO studentDAO = new StudentDAOImpl();
        Student student = new Student();
        student.setName("xyg");
        student.setAge(33);
        studentDAO.save(student);
    }
}
