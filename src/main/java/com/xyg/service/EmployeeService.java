package com.xyg.service;

import com.xyg.domain.Employee;
import com.xyg.repository.EmployeeCrudRepository;
import com.xyg.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    @Transactional
    public void update(String name) {
        employeeRepository.update(name);
    }

    @Transactional
    public void delete(String name) {
        employeeRepository.delete(name);
    }

    @Transactional
    public void save(List<Employee> employees) {
        employeeCrudRepository.save(employees);
    }
}
