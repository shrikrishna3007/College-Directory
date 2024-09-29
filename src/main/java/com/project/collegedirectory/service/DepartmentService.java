package com.project.collegedirectory.service;

import com.project.collegedirectory.entity.DepartmentEntity;
import com.project.collegedirectory.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public ResponseEntity<DepartmentEntity> createDepartment(DepartmentEntity departmentEntity) {
        return ResponseEntity.ok(departmentRepository.save(departmentEntity));
    }

    public ResponseEntity<List<DepartmentEntity>> getDepartmentList() {
         return ResponseEntity.ok(departmentRepository.findAll());
    }

    public ResponseEntity<DepartmentEntity> getDepartmentById(Long id) {
        Optional<DepartmentEntity> departmentEntity= departmentRepository.findById(id);
        if (departmentEntity.isPresent()){
            return ResponseEntity.ok(departmentEntity.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    public DepartmentEntity updateDepartment(Long id, DepartmentEntity updatedDepartmentEntity) {
        Optional<DepartmentEntity> departmentEntityOptional = departmentRepository.findById(id);
        if (departmentEntityOptional.isPresent()) {
            updatedDepartmentEntity.setId(id);
            return departmentRepository.save(updatedDepartmentEntity);
        } else {
            throw new RuntimeException("Couldn't find department...'");
        }
    }
}
