package com.example.springlearn.service;

import com.example.springlearn.model.Employee;
import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);

    Employee getEmployeeByEmail(String email);

    List<Employee> getEmployeesByDepartment(Long departmentId);

    List<Employee> getEmployeesByCountry(Long countryId);

    List<Employee> getActiveEmployees();

    List<Employee> getEmployeesByPosition(String position);

    List<Employee> getEmployeesBySalaryGreaterThan(Double salary);

    boolean employeeExists(Long id);
}