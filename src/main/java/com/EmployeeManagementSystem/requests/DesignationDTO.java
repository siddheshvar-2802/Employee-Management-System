package com.EmployeeManagementSystem.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DesignationDTO {

    private String designationName;
    private String DesignationDescription;
}
