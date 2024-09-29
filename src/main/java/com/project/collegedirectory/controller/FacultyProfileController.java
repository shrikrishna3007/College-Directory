package com.project.collegedirectory.controller;

import com.project.collegedirectory.entity.FacultyProfile;
import com.project.collegedirectory.service.FacultyProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty-profile")
@CrossOrigin
public class FacultyProfileController {
    @Autowired
    private FacultyProfileService facultyProfileService;

    @PreAuthorize("hasAuthority('FacultyMember')")
    @PostMapping("/faculty")
    public ResponseEntity<FacultyProfile> createFacultyProfile(@RequestBody FacultyProfile facultyProfile){
        try {
            return ResponseEntity.ok(facultyProfileService.createFacultyProfile(facultyProfile));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasAuthority('Administrator')")
    @GetMapping("/faculty")
    public ResponseEntity<List<FacultyProfile>> getFacultyList() {
        try {
            return ResponseEntity.ok(facultyProfileService.getFacultyList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasAuthority('FacultyMember')")
    @GetMapping("/{id}")
    public ResponseEntity<FacultyProfile> getFacultyById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(facultyProfileService.getFacultyById(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasAuthority('FacultyMember')")
    @PutMapping("/{id}")
    public ResponseEntity<FacultyProfile> updateFacultyProfile(@PathVariable Long id, @RequestBody FacultyProfile updatedFacultyProfile) {
        try {
            return ResponseEntity.ok(facultyProfileService.updateFacultyProfile(id, updatedFacultyProfile));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasAuthority('FacultyMember')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFacultyProfile(@PathVariable Long id){
        try {
            facultyProfileService.deleteFacultyProfile(id);
            return ResponseEntity.ok("Faculty profile deleted successfully!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
