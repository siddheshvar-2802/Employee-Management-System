package com.EmployeeManagementSystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Pattern;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Employees")
public class Employee {

    @Id
    @Column(name = "employee_Id",length = 30)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_Name", length = 30)
    private String firstName;

    @Column(name = "last_Name", length = 30)
    private String lastName;

    @Column(name = "email", length = 40)
    private String emailId;

    @Column(name = "contact",length = 14)
    @Pattern(regexp = "\\+91\\s\\d{10}", message = "Invalid phone number format. Example: +91 1234567890")
    private String contact;

    @Column(name = "date_Of_Birth",length = 10)
    private Date birthdate;

    @Column(name = "address", length = 100)
    private String address;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
