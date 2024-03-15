package com.EmployeeManagementSystem.Controller;

import com.EmployeeManagementSystem.Entity.Designation;
import com.EmployeeManagementSystem.ReuestDTO.DesignationDTO;
import com.EmployeeManagementSystem.Service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/Designation")
public class DesignationController {
    @Autowired
    private DesignationService designationService;

    @PostMapping("/add")
    public ResponseEntity<String> addDesignation(@RequestBody DesignationDTO designationDTO){
        designationService.addDesignation(designationDTO);
        return ResponseEntity.ok("Designation Added!");
    }

    @GetMapping("/getAll")
    public List<Designation> getAllDesignation(){
        return new ArrayList<Designation>(designationService.getAllDesignations());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Designation> getDesignationById(@PathVariable Integer id){
        return new ResponseEntity<Designation>(designationService.getDesignationById(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateDesignation(@PathVariable Integer id,
                                                    @RequestBody DesignationDTO designationDTO){
        designationService.updateDesignationByd(id,designationDTO);
        return ResponseEntity.ok("Designation Updated!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDesignation(@PathVariable Integer id){
        designationService.deleteDesignationById(id);
        return ResponseEntity.ok("Designation deleted successfully!");
    }
}
