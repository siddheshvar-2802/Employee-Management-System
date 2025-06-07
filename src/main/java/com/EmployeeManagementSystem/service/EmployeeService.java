package com.EmployeeManagementSystem.service;

import com.EmployeeManagementSystem.entity.Employee;
import com.EmployeeManagementSystem.requests.EmployeeDTO;

import java.util.List;


public interface EmployeeService {
    Employee addEmployee(EmployeeDTO employeeDTO);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(Integer id);

    Employee updateEmployeeById(Integer id, EmployeeDTO employeeDTO);

    void deleteEmployeeById(Integer employeeId);


}
