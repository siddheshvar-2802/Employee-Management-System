package com.EmployeeManagementSystem.Controller;

import com.EmployeeManagementSystem.ReuestDTO.EmployeeDTO;
import com.EmployeeManagementSystem.Entity.Employee;
import com.EmployeeManagementSystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/Save")
    public ResponseEntity<String> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        employeeService.addEmployee(employeeDTO);
        return ResponseEntity.ok("New Employee Added Successfully!");
    }

    @GetMapping("/GetAll")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/GetEmployee/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer employeeId){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.FOUND);
    }

    @PutMapping("/update/{employeeId}")
    public ResponseEntity<String> updateEmployeeById(@PathVariable Integer employeeId,
                                                     @RequestBody EmployeeDTO employeeDTO){
        employeeService.updateEmployeeById(employeeDTO,employeeId);
        return ResponseEntity.ok("Employee details are updated successfully!");
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Integer employeeId){
        employeeService.deleteEmployeeById(employeeId);
        return ResponseEntity.ok("Employee id "+employeeId+" is deleted!");
    }
}
