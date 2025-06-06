package com.EmployeeManagementSystem.Service.Impl;

import com.EmployeeManagementSystem.Entity.Designation;
import com.EmployeeManagementSystem.Repository.DesignationRepository;
import com.EmployeeManagementSystem.ReuestDTO.DesignationDTO;
import com.EmployeeManagementSystem.Service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DesignationImpl implements DesignationService {
    @Autowired
    private DesignationRepository designationRepository;

    @Override
    public Designation addDesignation(DesignationDTO designationDTO) {
        Designation newDesignation = new Designation();

        newDesignation.setDesignationName(designationDTO.getDesignationName());
        //newDesignation.setGetDesignationDescription(designationDTO.getDesignationDescription());

        return this.designationRepository.save(newDesignation);
    }

    @Override
    public List<Designation> getAllDesignations() {
        return this.designationRepository.findAll();
    }

    @Override
    public Designation getDesignationById(Integer id) {
        return this.designationRepository.findById(id).orElseThrow(()->
                new RuntimeException("No such designation found!"));
    }

    @Override
    public Designation updateDesignationByd(Integer id, DesignationDTO designationDTO) {
        Designation exDesignation = designationRepository.findById(id).orElseThrow(()->
                new RuntimeException("No such designation found!"));

        exDesignation.setDesignationName(designationDTO.getDesignationName());
        //exDesignation.setGetDesignationDescription(designationDTO.getDesignationDescription());

        return this.designationRepository.save(exDesignation);
    }

    @Override
    public void deleteDesignationById(Integer id) {
        designationRepository.findById(id).orElseThrow(()->
                new RuntimeException("No such designation found!"));
        designationRepository.deleteById(id);
    }
}
