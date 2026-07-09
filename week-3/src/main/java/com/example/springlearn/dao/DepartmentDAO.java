package com.example.springlearn.dao;

import com.example.springlearn.model.Department;
import java.util.List;
import java.util.Optional;

public interface DepartmentDAO {

    Department save(Department department);

    Optional<Department> findById(Long id);

    List<Department> findAll();

    Department update(Department department);

    void deleteById(Long id);

    boolean existsById(Long id);

    boolean existsByName(String name);

    boolean existsByDepartmentCode(String departmentCode);

    Optional<Department> findByName(String name);

    Optional<Department> findByDepartmentCode(String departmentCode);

    List<Department> findActiveDepartments();
}