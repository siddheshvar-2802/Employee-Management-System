package com.EmployeeManagementSystem.controller;

import com.EmployeeManagementSystem.entity.Designation;
import com.EmployeeManagementSystem.requests.DesignationDTO;
import com.EmployeeManagementSystem.service.DesignationService;
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
@RequestMapping("/api/Designation")
public class DesignationController {
    @Autowired
    private DesignationService designationService;

    @PostMapping("/add")
    public ResponseEntity<String> addDesignation(@RequestBody DesignationDTO designationDTO) {
        designationService.addDesignation(designationDTO);
        return ResponseEntity.ok("Designation Added!");
    }

    @GetMapping("/getAll")
    public List<Designation> getAllDesignation() {
        return new ArrayList<Designation>(designationService.getAllDesignations());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Designation> getDesignationById(@PathVariable Integer id) {
        return new ResponseEntity<Designation>(designationService.getDesignationById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateDesignation(@PathVariable Integer id,
                                                    @RequestBody DesignationDTO designationDTO) {
        designationService.updateDesignationByd(id, designationDTO);
        return ResponseEntity.ok("Designation Updated!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDesignation(@PathVariable Integer id) {
        designationService.deleteDesignationById(id);
        return ResponseEntity.ok("Designation deleted successfully!");
    }
}
