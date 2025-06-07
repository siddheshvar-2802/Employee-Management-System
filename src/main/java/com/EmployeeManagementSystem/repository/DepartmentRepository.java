package com.EmployeeManagementSystem.repository;

import com.EmployeeManagementSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    List<Department> findAllDepartmentByIsDeleted(boolean b);
}
