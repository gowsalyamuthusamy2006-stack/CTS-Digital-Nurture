package com.example.springlearn.dao;

import com.example.springlearn.model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {

    Employee save(Employee employee);

    Optional<Employee> findById(Long id);

    List<Employee> findAll();

    Employee update(Employee employee);

    void deleteById(Long id);

    boolean existsById(Long id);

    boolean existsByEmail(String email);

    Optional<Employee> findByEmail(String email);

    List<Employee> findByDepartmentId(Long departmentId);

    List<Employee> findByCountryId(Long countryId);

    List<Employee> findActiveEmployees();

    List<Employee> findByPosition(String position);

    List<Employee> findBySalaryGreaterThan(Double salary);
}