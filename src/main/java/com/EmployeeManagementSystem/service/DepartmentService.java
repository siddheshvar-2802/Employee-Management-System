package com.EmployeeManagementSystem.service;

import com.EmployeeManagementSystem.entity.Department;
import com.EmployeeManagementSystem.requests.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    Department addDepartment(DepartmentDTO departmentDTO);

    List<Department> getAllDepartment();

    Department getDepartmentById(Integer id);

    Department updateDepartmentById(Integer id, DepartmentDTO departmentDTO);

    void deleteDepartmentById(Integer id);
}
