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
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "designation_master")
public class Designation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "designation_name")
    private String designationName;

    @Column(name = "designation_description")
    private String designationDescription;

    @Column(name = "IsDeleted")
    private Boolean isDeleted;

    @Column(name = "CreatedBy")
    private String createdBy;

    @Column(name = "CreatedOn")
    private LocalDate createdOn;

    @Column(name = "ModifiedBy")
    private String modifiedBy;

    @Column(name = "ModifiedOn")
    private LocalDate modifiedOn;

}
