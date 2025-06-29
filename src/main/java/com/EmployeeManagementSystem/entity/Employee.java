package com.EmployeeManagementSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee_master")
public class Employee {

    @Id
    @Column(name = "employee_id", length = 30)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", length = 20)
    private String firstName;

    @Column(name = "father_name", length = 20)
    private String fatherName;

    @Column(name = "last_name", length = 20)
    private String lastName;

    @Column(name = "email", length = 40)
    private String emailId;

    @Column(name = "contact", length = 14)
    @Pattern(regexp = "\\+91\\s\\d{10}", message = "Invalid phone number format. Example: +91 1234567890")
    private String contact;

    @Column(name = "date_of_birth", length = 10)
    private Date birthdate;

    @ManyToOne
    @JoinColumn(name = "fk_address_id")
    private EmpAddress address;

    @ManyToOne
    @JoinColumn(name = "fk_department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "fk_designation_id")
    private Designation designation;

    @Column(name = "IsDeleted")
    private Boolean isDeleted;

    @Column(name = "CreatedBy")
    private String createdBy;

    @Column(name = "CreatedOn")
    private LocalDateTime createdOn;

    @Column(name = "ModifiedBy")
    private String modifiedBy;

    @Column(name = "ModifiedOn")
    private LocalDateTime modifiedOn;

}
