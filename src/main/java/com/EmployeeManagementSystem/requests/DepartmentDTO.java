package com.EmployeeManagementSystem.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class DepartmentDTO {

    @NotBlank
    private String departmentName;

    @NotBlank
    private String departmentDescription;

    private String createdBy;

}
