package com.EmployeeManagementSystem.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class DepartmentDTO {

    @NotBlank
    private String departmentName;

    @NotBlank
    private String departmentDescription;

    private LocalDate createdOn;
    private String createdBy;

}
