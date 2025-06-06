package com.EmployeeManagementSystem.controller;


import com.EmployeeManagementSystem.entity.Department;
import com.EmployeeManagementSystem.requests.DepartmentDTO;
import com.EmployeeManagementSystem.response.DepartmentResponse;
import com.EmployeeManagementSystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add")
    public ResponseEntity<?> saveDepartment(@RequestBody DepartmentDTO departmentDTO) {
        try {
            String response = departmentService.addDepartment(departmentDTO);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/GetAll")
    public ResponseEntity<?> getAllDepartment() {
        try {
            List<DepartmentResponse> allDepartment = departmentService.getAllDepartment();
            return new ResponseEntity<>(allDepartment, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Get/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Integer id) {
        return new ResponseEntity<Department>(departmentService.getDepartmentById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateDepartmentById(@PathVariable Integer id,
                                                       @RequestBody DepartmentDTO departmentDTO) {
        departmentService.updateDepartmentById(id, departmentDTO);
        return ResponseEntity.ok("Department updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable Integer id) {
        departmentService.deleteDepartmentById(id);
        return ResponseEntity.ok("Department deleted!");
    }
}
