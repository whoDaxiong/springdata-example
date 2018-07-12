package com.xyg.dao;

import com.xyg.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOSpringJdbcImpl implements StudentDAO {
    final List<Student> students = new ArrayList<>();
    private JdbcTemplate jdbcTemplate;
    String sql = "select * from student";

    @Override
    public List<Student> query() {
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);
                students.add(student);
            }
        });
        return students;
    }

    @Override
    public void save(Student student) {
        String sql = "insert into student(name,age) VALUES(?,?)";
        jdbcTemplate.update(sql,new Object[]{student.getName(),student.getAge()});
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
