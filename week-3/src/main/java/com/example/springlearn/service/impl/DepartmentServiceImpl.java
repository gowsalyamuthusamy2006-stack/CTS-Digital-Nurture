package com.example.springlearn.service.impl;

import com.example.springlearn.dao.DepartmentDAO;
import com.example.springlearn.exception.DuplicateResourceException;
import com.example.springlearn.exception.ResourceNotFoundException;
import com.example.springlearn.model.Department;
import com.example.springlearn.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Autowired
    private DepartmentDAO departmentDAO;

    public Department createDepartment(Department department) {
        logger.info("Creating department: {}", department.getName());
        if (departmentDAO.existsByName(department.getName())) {
            throw new DuplicateResourceException("Department", "name", department.getName());
        }
        if (departmentDAO.existsByDepartmentCode(department.getDepartmentCode())) {
            throw new DuplicateResourceException("Department", "code", department.getDepartmentCode());
        }
        return departmentDAO.save(department);
    }

    public Department getDepartmentById(Long id) {
        return departmentDAO.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", id));
    }

    public List<Department> getAllDepartments() {
        return departmentDAO.findAll();
    }

    public Department updateDepartment(Long id, Department department) {
        Department existing = getDepartmentById(id);
        if (!existing.getName().equals(department.getName()) && departmentDAO.existsByName(department.getName())) {
            throw new DuplicateResourceException("Department", "name", department.getName());
        }
        if (!existing.getDepartmentCode().equals(department.getDepartmentCode()) && 
                departmentDAO.existsByDepartmentCode(department.getDepartmentCode())) {
            throw new DuplicateResourceException("Department", "code", department.getDepartmentCode());
        }
        existing.setName(department.getName());
        existing.setDescription(department.getDescription());
        existing.setDepartmentCode(department.getDepartmentCode());
        existing.setBudget(department.getBudget());
        return departmentDAO.update(existing);
    }

    public void deleteDepartment(Long id) {
        if (!departmentDAO.existsById(id)) {
            throw new ResourceNotFoundException("Department", "id", id);
        }
        departmentDAO.deleteById(id);
    }

    public Department getDepartmentByName(String name) {
        return departmentDAO.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "name", name));
    }

    public Department getDepartmentByCode(String code) {
        return departmentDAO.findByDepartmentCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "code", code));
    }

    public List<Department> getActiveDepartments() {
        return departmentDAO.findActiveDepartments();
    }

    public boolean departmentExists(Long id) {
        return departmentDAO.existsById(id);
    }
}