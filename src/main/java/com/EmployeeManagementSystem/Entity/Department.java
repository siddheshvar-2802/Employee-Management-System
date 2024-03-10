package com.EmployeeManagementSystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String departmentName;
    private String departmentDescription;

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private List<Employee> employees;
}
