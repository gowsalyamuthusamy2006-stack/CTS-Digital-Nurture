package com.example.springlearn.service;

import com.example.springlearn.model.Department;
import java.util.List;

public interface DepartmentService {

    Department createDepartment(Department department);

    Department getDepartmentById(Long id);

    List<Department> getAllDepartments();

    Department updateDepartment(Long id, Department department);

    void deleteDepartment(Long id);

    Department getDepartmentByName(String name);

    Department getDepartmentByCode(String code);

    List<Department> getActiveDepartments();

    boolean departmentExists(Long id);
}