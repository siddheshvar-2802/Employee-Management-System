package com.EmployeeManagementSystem.service;

import com.EmployeeManagementSystem.entity.Designation;
import com.EmployeeManagementSystem.requests.DesignationDTO;

import java.util.List;

public interface DesignationService {

    Designation addDesignation(DesignationDTO designationDTO);

    List<Designation> getAllDesignations();

    Designation getDesignationById(Integer id);

    Designation updateDesignationByd(Integer id, DesignationDTO designationDTO);

    void deleteDesignationById(Integer id);
}
