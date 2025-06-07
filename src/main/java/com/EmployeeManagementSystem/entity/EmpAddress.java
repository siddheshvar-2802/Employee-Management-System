package com.EmployeeManagementSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee_address")
public class EmpAddress {
    @Id
    @Column(name = "emp_address_id", length = 30)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "current_address", length = 50)
    private String currentAddress;

    @Column(name = "current_city", length = 20)
    private String currentCity;

    @Column(name = "current_state", length = 20)
    private String currentState;

    @Column(name = "current_pin", length = 6)
    private int currentPin;

    @Column(name = "permanent_address", length = 50)
    private String permanentAddress;

    @Column(name = "permanent_city", length = 20)
    private String permanentCity;

    @Column(name = "permanent_state", length = 20)
    private String permanentState;

    @Column(name = "permanent_pin", length = 6)
    private int permanentPin;

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
