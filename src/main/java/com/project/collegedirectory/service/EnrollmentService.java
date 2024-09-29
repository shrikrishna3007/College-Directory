package com.project.collegedirectory.service;

import com.project.collegedirectory.entity.EnrollmentEntity;
import com.project.collegedirectory.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public EnrollmentEntity addEnrollDetails(EnrollmentEntity enrollmentEntity) {
        try {
            return enrollmentRepository.save(enrollmentEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<EnrollmentEntity> getEnrollmentDetails() {
        try {
            return enrollmentRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public EnrollmentEntity getEnrollmentDetailsById(Long id) {
        Optional<EnrollmentEntity> enrollmentEntity=enrollmentRepository.findById(id);
        if(enrollmentEntity.isPresent()){
            return enrollmentEntity.get();
        } else{
            throw new RuntimeException("Enrollment not found for id " + id);
        }
    }

    public String deleteEnrollment(Long id) {
        Optional<EnrollmentEntity> enrollmentEntity=enrollmentRepository.findById(id);
        if(enrollmentEntity.isPresent()){
            enrollmentRepository.deleteById(id);
            return "Enrollment deleted successfully";
        }
        return "Enrollment not found";
    }
}
