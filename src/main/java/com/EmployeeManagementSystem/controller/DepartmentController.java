package com.EmployeeManagementSystem.controller;


import com.EmployeeManagementSystem.requests.DepartmentDTO;
import com.EmployeeManagementSystem.response.DepartmentResponse;
import com.EmployeeManagementSystem.service.DepartmentService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
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

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable Integer id) {
        try {
            DepartmentResponse department = departmentService.getDepartmentById(id);
            return ResponseEntity.ok(department);
        } catch (EntityNotFoundException enfe) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(enfe.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to retrieve department: " + e.getMessage());
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateDepartmentById(@PathVariable @NotNull Integer id,
                                                       @RequestBody @Valid DepartmentDTO departmentDTO) {
        try {
            String response = departmentService.updateDepartmentById(id, departmentDTO);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (EntityNotFoundException enfe) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(enfe.getMessage());
        } catch (IllegalArgumentException iae) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(iae.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update department: " + e.getMessage());
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable Integer id) {
        try {
            String result = departmentService.deleteDepartmentById(id);
            return ResponseEntity.ok(result);
        } catch (EntityNotFoundException enfe) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(enfe.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete department: " + e.getMessage());
        }
    }

}
