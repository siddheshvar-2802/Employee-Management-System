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

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
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
            newDepartment.setIsDeleted(false);
            newDepartment.setCreatedBy(departmentDTO.getUser());
            newDepartment.setCreatedOn(LocalDateTime.now());
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
    public DepartmentResponse getDepartmentById(Integer id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department with ID " + id + " not found"));

        return mapToDepartmentResponse(department);
    }

    @Override
    public String updateDepartmentById(Integer id, DepartmentDTO departmentDTO) {
        if (departmentDTO == null) {
            throw new IllegalArgumentException("DepartmentDTO cannot be null");
        }

        try {
            Department department = departmentRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Department with ID " + id + " not found"));

            if (departmentDTO.getDepartmentName() != null) {
                department.setDepartmentName(departmentDTO.getDepartmentName());
            }

            if (departmentDTO.getDepartmentDescription() != null) {
                department.setDepartmentDescription(departmentDTO.getDepartmentDescription());
            }

            department.setModifiedBy(departmentDTO.getUser() != null ? departmentDTO.getUser() : "System");
            department.setModifiedOn(LocalDateTime.now());

            departmentRepository.saveAndFlush(department);

            return "Department with ID " + id + " successfully updated";
        } catch (EntityNotFoundException enfe) {
            log.error("Update failed: {}", enfe.getMessage());
            throw enfe;
        } catch (Exception e) {
            log.error("Unexpected error while updating department with ID {}: {}", id, e.getMessage(), e);
            throw new RuntimeException("An unexpected error occurred while updating the department", e);
        }
    }


    @Override
    public String deleteDepartmentById(Integer id) {
        try {
            Department department = departmentRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Department with ID " + id + " not found for deletion"));

            departmentRepository.delete(department);
            log.info("Successfully deleted department with ID {}", id);
            return "Department with ID " + id + " was successfully deleted.";
        } catch (EntityNotFoundException enfe) {
            log.warn("Delete failed: {}", enfe.getMessage());
            return enfe.getMessage();
        } catch (Exception e) {
            log.error("Unexpected error while deleting department with ID {}: {}", id, e.getMessage(), e);
            return "An unexpected error occurred while deleting the department.";
        }
    }

    private DepartmentResponse mapToDepartmentResponse(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("Department cannot be null");
        }

        DepartmentResponse response = new DepartmentResponse();
        response.setDepartmentId(department.getId());
        response.setDepartmentName(department.getDepartmentName());
        response.setDepartmentDescription(department.getDepartmentDescription());
        response.setIsDeleted(department.getIsDeleted());

        return response;
    }

}
