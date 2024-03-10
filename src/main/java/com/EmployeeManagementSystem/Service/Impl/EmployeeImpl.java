package com.EmployeeManagementSystem.Service.Impl;

import com.EmployeeManagementSystem.ReuestDTO.EmployeeDTO;
import com.EmployeeManagementSystem.Entity.Employee;
import com.EmployeeManagementSystem.Repository.EmployeeRepository;
import com.EmployeeManagementSystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(EmployeeDTO employeeDTO) {
        Employee newEmployee = new Employee();
        newEmployee.setId(employeeDTO.getId());
        newEmployee.setFirstName(employeeDTO.getFirstName());
        newEmployee.setLastName(employeeDTO.getLastName());
        newEmployee.setEmailId(employeeDTO.getEmailId());
        newEmployee.setContact(employeeDTO.getContact());
        newEmployee.setBirthdate(employeeDTO.getBirthdate());
        newEmployee.setAddress(employeeDTO.getAddress());

        return employeeRepository.save(newEmployee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(()->
                new RuntimeException("Employee not found!"));
    }

    @Override
    public Employee updateEmployeeById(Integer id, EmployeeDTO employeeDTO) {
        Employee exEmp = employeeRepository.findById(id).orElseThrow(()->
                new RuntimeException("Employee not found!"));

//        exEmp.setId(employeeDTO.getId());
        exEmp.setFirstName(employeeDTO.getFirstName());
        exEmp.setLastName(employeeDTO.getLastName());
        exEmp.setEmailId(employeeDTO.getEmailId());
        exEmp.setBirthdate(employeeDTO.getBirthdate());
        exEmp.setContact(employeeDTO.getContact());
        exEmp.setAddress(employeeDTO.getAddress());
        return this.employeeRepository.save(exEmp);
    }

    @Override
    public void deleteEmployeeById(Integer employeeId) {
        employeeRepository.findById(employeeId).orElseThrow(()->
                new RuntimeException("Employee not found!"));
        employeeRepository.deleteById(employeeId);
    }

}
