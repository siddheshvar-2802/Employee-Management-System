package com.EmployeeManagementSystem.Service;

import com.EmployeeManagementSystem.ReuestDTO.EmployeeDTO;
import com.EmployeeManagementSystem.Entity.Employee;
import java.util.List;


public interface EmployeeService {
    Employee addEmployee(EmployeeDTO employeeDTO);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(Integer employeeId);
    Employee updateEmployeeById(EmployeeDTO employeeDTO, Integer employeeId);
    void deleteEmployeeById(Integer employeeId);


}
