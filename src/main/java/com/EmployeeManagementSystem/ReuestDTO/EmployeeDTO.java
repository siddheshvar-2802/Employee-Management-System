package com.EmployeeManagementSystem.ReuestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class EmployeeDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String contact;
    private Date birthdate;
    private String address;

}