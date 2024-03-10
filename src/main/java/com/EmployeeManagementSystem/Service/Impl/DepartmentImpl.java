package com.EmployeeManagementSystem.Service.Impl;

import com.EmployeeManagementSystem.Entity.Department;
import com.EmployeeManagementSystem.Repository.DepartmentRepository;
import com.EmployeeManagementSystem.ReuestDTO.DepartmentDTO;
import com.EmployeeManagementSystem.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class DepartmentImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department addDepartment(DepartmentDTO departmentDTO) {
        Department newDepartment = new Department();
        newDepartment.setDepartmentName(departmentDTO.getDepartmentName());
        newDepartment.setDepartmentDescription(departmentDTO.getDepartmentDescription());
        return this.departmentRepository.save(newDepartment);
    }

    @Override
    public List<Department> getAllDepartment() {
        return this.departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Integer id) {
        return this.departmentRepository.findById(id).orElseThrow(()->
                new RuntimeException("Department not found!"));
    }

    @Override
    public Department updateDepartmentById(Integer id, DepartmentDTO departmentDTO) {
        Department oldDepartment = departmentRepository.findById(id).orElseThrow(()->
                new RuntimeException("Department not found to update!"));

        oldDepartment.setDepartmentName(departmentDTO.getDepartmentName());
        oldDepartment.setDepartmentDescription(departmentDTO.getDepartmentDescription());

        return this.departmentRepository.save(oldDepartment);
    }

    @Override
    public void deleteDepartmentById(Integer id) {
        departmentRepository.findById(id).orElseThrow(()->
                new RuntimeException("No department found to delete!"));
        departmentRepository.deleteById(id);
    }
}
