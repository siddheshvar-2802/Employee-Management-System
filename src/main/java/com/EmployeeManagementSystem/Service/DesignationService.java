package com.EmployeeManagementSystem.Service;

import com.EmployeeManagementSystem.Entity.Designation;
import com.EmployeeManagementSystem.ReuestDTO.DesignationDTO;
import java.util.List;

public interface DesignationService {

    Designation addDesignation(DesignationDTO designationDTO);
    List<Designation> getAllDesignations();
    Designation getDesignationById(Integer id);
    Designation updateDesignationByd(Integer id, DesignationDTO designationDTO);
    void deleteDesignationById(Integer id);
}
