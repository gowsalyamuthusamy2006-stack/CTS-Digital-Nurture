package com.example.springlearn.service.impl;

import com.example.springlearn.dao.EmployeeDAO;
import com.example.springlearn.exception.DuplicateResourceException;
import com.example.springlearn.exception.ResourceNotFoundException;
import com.example.springlearn.model.Employee;
import com.example.springlearn.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeDAO employeeDAO;

    public Employee createEmployee(Employee employee) {
        logger.info("Creating employee: {}", employee.getEmail());
        if (employeeDAO.existsByEmail(employee.getEmail())) {
            throw new DuplicateResourceException("Employee", "email", employee.getEmail());
        }
        if (employee.getHireDate() == null) {
            employee.setHireDate(LocalDate.now());
        }
        return employeeDAO.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeDAO.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee existing = getEmployeeById(id);
        if (!existing.getEmail().equals(employee.getEmail()) && employeeDAO.existsByEmail(employee.getEmail())) {
            throw new DuplicateResourceException("Employee", "email", employee.getEmail());
        }
        existing.setFirstName(employee.getFirstName());
        existing.setLastName(employee.getLastName());
        existing.setEmail(employee.getEmail());
        existing.setPhoneNumber(employee.getPhoneNumber());
        existing.setDateOfBirth(employee.getDateOfBirth());
        existing.setPosition(employee.getPosition());
        existing.setSalary(employee.getSalary());
        existing.setDepartment(employee.getDepartment());
        existing.setCountry(employee.getCountry());
        return employeeDAO.update(existing);
    }

    public void deleteEmployee(Long id) {
        if (!employeeDAO.existsById(id)) {
            throw new ResourceNotFoundException("Employee", "id", id);
        }
        employeeDAO.deleteById(id);
    }

    public Employee getEmployeeByEmail(String email) {
        return employeeDAO.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "email", email));
    }

    public List<Employee> getEmployeesByDepartment(Long departmentId) {
        return employeeDAO.findByDepartmentId(departmentId);
    }

    public List<Employee> getEmployeesByCountry(Long countryId) {
        return employeeDAO.findByCountryId(countryId);
    }

    public List<Employee> getActiveEmployees() {
        return employeeDAO.findActiveEmployees();
    }

    public List<Employee> getEmployeesByPosition(String position) {
        return employeeDAO.findByPosition(position);
    }

    public List<Employee> getEmployeesBySalaryGreaterThan(Double salary) {
        return employeeDAO.findBySalaryGreaterThan(salary);
    }

    public boolean employeeExists(Long id) {
        return employeeDAO.existsById(id);
    }
}