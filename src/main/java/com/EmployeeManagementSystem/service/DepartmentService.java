package com.EmployeeManagementSystem.service;

import com.EmployeeManagementSystem.requests.DepartmentDTO;
import com.EmployeeManagementSystem.response.DepartmentResponse;
import javassist.NotFoundException;

import java.util.List;

public interface DepartmentService {

    String addDepartment(DepartmentDTO departmentDTO);

    List<DepartmentResponse> getAllDepartment() throws NotFoundException;

    DepartmentResponse getDepartmentById(Integer id);

    String updateDepartmentById(Integer id, DepartmentDTO departmentDTO);

    String deleteDepartmentById(Integer id);
}
