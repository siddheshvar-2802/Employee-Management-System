package com.EmployeeManagementSystem.Repository;

import com.EmployeeManagementSystem.Entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignationRepository extends JpaRepository<Designation,Integer> {
}
