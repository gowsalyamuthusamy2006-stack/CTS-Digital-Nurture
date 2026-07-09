package com.example.springlearn.dao.impl;

import com.example.springlearn.dao.DepartmentDAO;
import com.example.springlearn.model.Department;
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
public class DepartmentDAOImpl implements DepartmentDAO {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentDAOImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Department save(Department department) {
        logger.debug("Saving department: {}", department.getName());
        entityManager.persist(department);
        return department;
    }

    @Override
    public Optional<Department> findById(Long id) {
        logger.debug("Finding department by id: {}", id);
        Department department = entityManager.find(Department.class, id);
        return Optional.ofNullable(department);
    }

    @Override
    public List<Department> findAll() {
        logger.debug("Finding all departments");
        TypedQuery<Department> query = entityManager.createQuery(
            "SELECT d FROM Department d", Department.class);
        return query.getResultList();
    }

    @Override
    public Department update(Department department) {
        logger.debug("Updating department: {}", department.getName());
        return entityManager.merge(department);
    }

    @Override
    public void deleteById(Long id) {
        logger.debug("Deleting department by id: {}", id);
        Department department = entityManager.find(Department.class, id);
        if (department != null) {
            entityManager.remove(department);
        }
    }

    @Override
    public boolean existsById(Long id) {
        logger.debug("Checking if department exists by id: {}", id);
        return entityManager.find(Department.class, id) != null;
    }

    @Override
    public boolean existsByName(String name) {
        logger.debug("Checking if department exists by name: {}", name);
        TypedQuery<Long> query = entityManager.createQuery(
            "SELECT COUNT(d) FROM Department d WHERE d.name = :name", Long.class);
        query.setParameter("name", name);
        return query.getSingleResult() > 0;
    }

    @Override
    public boolean existsByDepartmentCode(String departmentCode) {
        logger.debug("Checking if department exists by code: {}", departmentCode);
        TypedQuery<Long> query = entityManager.createQuery(
            "SELECT COUNT(d) FROM Department d WHERE d.departmentCode = :code", Long.class);
        query.setParameter("code", departmentCode);
        return query.getSingleResult() > 0;
    }

    @Override
    public Optional<Department> findByName(String name) {
        logger.debug("Finding department by name: {}", name);
        TypedQuery<Department> query = entityManager.createQuery(
            "SELECT d FROM Department d WHERE d.name = :name", Department.class);
        query.setParameter("name", name);
        return query.getResultList().stream().findFirst();
    }

    @Override
    public Optional<Department> findByDepartmentCode(String departmentCode) {
        logger.debug("Finding department by code: {}", departmentCode);
        TypedQuery<Department> query = entityManager.createQuery(
            "SELECT d FROM Department d WHERE d.departmentCode = :code", Department.class);
        query.setParameter("code", departmentCode);
        return query.getResultList().stream().findFirst();
    }

    @Override
    public List<Department> findActiveDepartments() {
        logger.debug("Finding all active departments");
        TypedQuery<Department> query = entityManager.createQuery(
            "SELECT d FROM Department d WHERE d.isActive = true", Department.class);
        return query.getResultList();
    }
}