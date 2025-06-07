package com.EmployeeManagementSystem.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class EmployeeDTO {

    private String firstName;
    private String lastName;

    @Email(message = "Invalid email format")
    private String emailId;

    @Pattern(regexp = "\\+91\\s\\d{10}", message = "Invalid phone number format. Example: +91 1234567890")
    private String contact;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthdate;

    private String address;

    @NotNull(message = "Department ID is required")
    private Integer departmentId;

    @NotNull(message = "Designation ID is required")
    private Integer designationId;

}