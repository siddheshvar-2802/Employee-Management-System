package com.EmployeeManagementSystem.ReuestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DesignationDTO {
    private Integer id;
    private String designationName;
    private String DesignationDescription;
}
