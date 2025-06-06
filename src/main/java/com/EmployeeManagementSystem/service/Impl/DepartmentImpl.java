package com.EmployeeManagementSystem.service.Impl;

import com.EmployeeManagementSystem.entity.Department;
import com.EmployeeManagementSystem.repository.DepartmentRepository;
import com.EmployeeManagementSystem.requests.DepartmentDTO;
import com.EmployeeManagementSystem.response.DepartmentResponse;
import com.EmployeeManagementSystem.service.DepartmentService;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DepartmentImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public String addDepartment(DepartmentDTO departmentDTO) {
        log.info("Received request to add new department: {}", departmentDTO.getDepartmentName());

        try {
            Department newDepartment = new Department();
            newDepartment.setDepartmentName(departmentDTO.getDepartmentName());
            newDepartment.setDepartmentDescription(departmentDTO.getDepartmentDescription());
            newDepartment.setCreatedBy(departmentDTO.getCreatedBy());
            newDepartment.setCreatedOn(departmentDTO.getCreatedOn());

            newDepartment = departmentRepository.save(newDepartment);

            log.info("Department '{}' saved successfully with ID: {}",
                    newDepartment.getDepartmentName(), newDepartment.getId());

            return "New Department has been added.";
        } catch (Exception e) {
            log.error("Error while adding department: {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<DepartmentResponse> getAllDepartment() throws NotFoundException {
        try {
            List<DepartmentResponse> finalResponse = new ArrayList<>();
            List<Department> departmentList = departmentRepository.findAllDepartmentByIsDeleted(false);
            if (!departmentList.isEmpty()) {
                for (Department department : departmentList) {
                    DepartmentResponse response = new DepartmentResponse();
                    response.setDepartmentId(department != null ? department.getId() : null);
                    response.setDepartmentName(department != null ? department.getDepartmentName() : null);
                    response.setDepartmentDescription(department != null ? department.getDepartmentDescription() : null);
                    response.setIsDeleted(department != null ? department.getIsDeleted() : null);
                    finalResponse.add(response);
                }
                return finalResponse;
            } else {
                throw new NotFoundException("No department found");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Department getDepartmentById(Integer id) {
        return this.departmentRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Department not found!"));
    }

    @Override
    public Department updateDepartmentById(Integer id, DepartmentDTO departmentDTO) {
        Department oldDepartment = departmentRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Department not found to update!"));

        oldDepartment.setDepartmentName(departmentDTO.getDepartmentName());
        oldDepartment.setDepartmentDescription(departmentDTO.getDepartmentDescription());

        return this.departmentRepository.save(oldDepartment);
    }

    @Override
    public void deleteDepartmentById(Integer id) {
        departmentRepository.findById(id).orElseThrow(() ->
                new RuntimeException("No department found to delete!"));
        departmentRepository.deleteById(id);
    }
}
