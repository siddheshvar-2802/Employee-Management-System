package com.EmployeeManagementSystem.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponse {
    private int departmentId;
    private String departmentName;
    private String departmentDescription;
    private Boolean isDeleted;
}
