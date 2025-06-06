package com.EmployeeManagementSystem.controller;


import com.EmployeeManagementSystem.entity.Department;
import com.EmployeeManagementSystem.requests.DepartmentDTO;
import com.EmployeeManagementSystem.service.DepartmentService;
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

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/Department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add")
    public ResponseEntity<String> saveDepartment(@RequestBody DepartmentDTO departmentDTO) {
        departmentService.addDepartment(departmentDTO);
        return ResponseEntity.ok("New Department Added!");
    }

    @GetMapping("/GetAll")
    public List<Department> getAllDepartment() {
        return new ArrayList<Department>(departmentService.getAllDepartment());
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
