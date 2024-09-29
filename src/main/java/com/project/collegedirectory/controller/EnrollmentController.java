package com.project.collegedirectory.controller;

import com.project.collegedirectory.entity.EnrollmentEntity;
import com.project.collegedirectory.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollment")
@CrossOrigin
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/details")
    public ResponseEntity<EnrollmentEntity> addEnrollDetails(EnrollmentEntity enrollmentEntity){
        try {
            return ResponseEntity.ok(enrollmentService.addEnrollDetails(enrollmentEntity));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasAuthority('Administrator')")
    @GetMapping("/list")
    public ResponseEntity<List<EnrollmentEntity>> getEnrollmentDetails(){
        try {
            return ResponseEntity.ok(enrollmentService.getEnrollmentDetails());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentEntity> getEnrollmentDetailsById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(enrollmentService.getEnrollmentDetailsById(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEnrollment(@PathVariable Long id){
        try {
            enrollmentService.deleteEnrollment(id);
            return ResponseEntity.ok("Enrollment deleted successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
