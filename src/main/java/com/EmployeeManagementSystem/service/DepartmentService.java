package com.EmployeeManagementSystem.service;

import com.EmployeeManagementSystem.entity.Department;
import com.EmployeeManagementSystem.requests.DepartmentDTO;
import com.EmployeeManagementSystem.response.DepartmentResponse;
import javassist.NotFoundException;

import java.util.List;

public interface DepartmentService {

    String addDepartment(DepartmentDTO departmentDTO);

    List<DepartmentResponse> getAllDepartment() throws NotFoundException;

    Department getDepartmentById(Integer id);

    Department updateDepartmentById(Integer id, DepartmentDTO departmentDTO);

    void deleteDepartmentById(Integer id);
}
