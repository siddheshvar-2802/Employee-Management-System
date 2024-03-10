package com.EmployeeManagementSystem.Service;

import com.EmployeeManagementSystem.Entity.Department;
import com.EmployeeManagementSystem.ReuestDTO.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    Department addDepartment(DepartmentDTO departmentDTO);
    List<Department> getAllDepartment();
    Department getDepartmentById(Integer id);
    Department updateDepartmentById(Integer id, DepartmentDTO departmentDTO);
    void deleteDepartmentById(Integer id);
}
