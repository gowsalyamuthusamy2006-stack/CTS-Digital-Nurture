package com.example.springlearn.dao.impl;

import com.example.springlearn.dao.EmployeeDAO;
import com.example.springlearn.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Employee save(Employee employee) {
        logger.debug("Saving employee: {}", employee.getEmail());
        entityManager.persist(employee);
        return employee;
    }

    @Override
    public Optional<Employee> findById(Long id) {
        logger.debug("Finding employee by id: {}", id);
        Employee employee = entityManager.find(Employee.class, id);
        return Optional.ofNullable(employee);
    }

    @Override
    public List<Employee> findAll() {
        logger.debug("Finding all employees");
        TypedQuery<Employee> query = entityManager.createQuery(
            "SELECT e FROM Employee e", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee update(Employee employee) {
        logger.debug("Updating employee: {}", employee.getEmail());
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(Long id) {
        logger.debug("Deleting employee by id: {}", id);
        Employee employee = entityManager.find(Employee.class, id);
        if (employee != null) {
            entityManager.remove(employee);
        }
    }

    @Override
    public boolean existsById(Long id) {
        logger.debug("Checking if employee exists by id: {}", id);
        return entityManager.find(Employee.class, id) != null;
    }

    @Override
    public boolean existsByEmail(String email) {
        logger.debug("Checking if employee exists by email: {}", email);
        TypedQuery<Long> query = entityManager.createQuery(
            "SELECT COUNT(e) FROM Employee e WHERE e.email = :email", Long.class);
        query.setParameter("email", email);
        return query.getSingleResult() > 0;
    }

    @Override
    public Optional<Employee> findByEmail(String email) {
        logger.debug("Finding employee by email: {}", email);
        TypedQuery<Employee> query = entityManager.createQuery(
            "SELECT e FROM Employee e WHERE e.email = :email", Employee.class);
        query.setParameter("email", email);
        return query.getResultList().stream().findFirst();
    }

    @Override
    public List<Employee> findByDepartmentId(Long departmentId) {
        logger.debug("Finding employees by department id: {}", departmentId);
        TypedQuery<Employee> query = entityManager.createQuery(
            "SELECT e FROM Employee e WHERE e.department.id = :deptId AND e.isActive = true", Employee.class);
        query.setParameter("deptId", departmentId);
        return query.getResultList();
    }

    @Override
    public List<Employee> findByCountryId(Long countryId) {
        logger.debug("Finding employees by country id: {}", countryId);
        TypedQuery<Employee> query = entityManager.createQuery(
            "SELECT e FROM Employee e WHERE e.country.id = :countryId AND e.isActive = true", Employee.class);
        query.setParameter("countryId", countryId);
        return query.getResultList();
    }

    @Override
    public List<Employee> findActiveEmployees() {
        logger.debug("Finding all active employees");
        TypedQuery<Employee> query = entityManager.createQuery(
            "SELECT e FROM Employee e WHERE e.isActive = true", Employee.class);
        return query.getResultList();
    }

    @Override
    public List<Employee> findByPosition(String position) {
        logger.debug("Finding employees by position: {}", position);
        TypedQuery<Employee> query = entityManager.createQuery(
            "SELECT e FROM Employee e WHERE e.position = :position AND e.isActive = true", Employee.class);
        query.setParameter("position", position);
        return query.getResultList();
    }

    @Override
    public List<Employee> findBySalaryGreaterThan(Double salary) {
        logger.debug("Finding employees with salary greater than: {}", salary);
        TypedQuery<Employee> query = entityManager.createQuery(
            "SELECT e FROM Employee e WHERE e.salary > :salary AND e.isActive = true", Employee.class);
        query.setParameter("salary", salary);
        return query.getResultList();
    }
}