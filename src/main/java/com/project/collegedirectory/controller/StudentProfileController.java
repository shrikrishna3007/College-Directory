package com.project.collegedirectory.controller;

import com.project.collegedirectory.entity.StudentProfile;
import com.project.collegedirectory.service.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student-profile")
@CrossOrigin
public class StudentProfileController {
    @Autowired
    private StudentProfileService studentProfileService;

    @PreAuthorize("hasAuthority('Student')")
    @PostMapping("/student-profile")
    public ResponseEntity<StudentProfile> createProfile(StudentProfile studentProfile){
        try {
            return ResponseEntity.ok(studentProfileService.createProfile(studentProfile));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasAuthority('Administrator')")
    @GetMapping("/")
    public ResponseEntity<List<StudentProfile>> getStudentProfiles(){
        try {
            return ResponseEntity.ok(studentProfileService.getStudentProfiles());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasAuthority('Student')")
    @GetMapping("/{studentId}")
    public ResponseEntity<Optional<StudentProfile>> getStudentProfileById(@PathVariable Long id){
        try {
            return studentProfileService.getStudentProfileById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasAuthority('Student')")
    @PutMapping("/{studentId}")
    public ResponseEntity<StudentProfile> updateStudentProfile(@PathVariable Long id, @RequestBody StudentProfile updatedProfile){
        try {
            return studentProfileService.updateStudentProfile(id, updatedProfile);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasAuthority('Student')")
    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudentProfile(@PathVariable Long id){
        try {
            studentProfileService.deleteStudentProfile(id);
            return ResponseEntity.ok("Student profile deleted successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
