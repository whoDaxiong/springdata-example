package com.xyg.dao;

import com.xyg.domain.Student;

import java.util.List;

/**
 * StudentDAO访问接口
 */
public interface StudentDAO {
    public List<Student> query();

    public void save(Student student);
}
