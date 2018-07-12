package com.xyg.repository;

import com.xyg.domain.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.List;

@RepositoryDefinition(domainClass = Employee.class,idClass = Integer.class)
public interface EmployeeRepository/* extends Repository<Employee,Integer>*/{
    public Employee findByName(String name);

    public List<Employee> findByNameStartingWithAndAgeLessThan(String name, Integer age);

    public List<Employee> findByNameEndingWithAndAgeEquals(String name, Integer age);

    public List<Employee> findByNameInOrAgeLessThan(List<String> names, Integer age);

    @Query("select o from Employee o where id=(select max(id) from Employee t1)")
    public Employee getEmployeeByIdMax();

    @Query("select e from Employee e WHERE e.name = ?1 and e.age = ?2")
    public List<Employee> getByNameAndAge(String name,Integer age);

    @Query("select e from Employee e WHERE e.name=:name and e.age =:age")
    public List<Employee> getByNameAndAge2(@Param("name") String name, @Param("age") Integer age);

    @Query("select e from Employee e WHERE e.name like %?1%")
    public List<Employee> getLikeName(String name);

    @Query(nativeQuery = true,value = "select count(*) from employee")
    public Long getCount();

    @Modifying
    @Query("update Employee set age = 23 where name = :name")
    public void update(@Param("name")String name);

    @Modifying
    @Query("delete from Employee where name = :name")
    public void delete(@Param("name")String name);

}
