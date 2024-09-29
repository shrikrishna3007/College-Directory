package com.project.collegedirectory.controller;

import com.project.collegedirectory.entity.AdministratorProfile;
import com.project.collegedirectory.service.AdministratorProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin-profile")
@CrossOrigin
public class AdministratorProfileController {
    @Autowired
    private AdministratorProfileService administratorProfileService;

    @PreAuthorize("hasAuthority('Administrator')")
    @PostMapping("/profile")
    public ResponseEntity<AdministratorProfile> createAdministratorProfile(@RequestBody AdministratorProfile administratorProfile){
        try {
            return ResponseEntity.ok(administratorProfileService.createAdministratorProfile(administratorProfile));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasAuthority('Administrator')")
    @GetMapping("/admin")
    public ResponseEntity<List<AdministratorProfile>> getAdministratorList(){
        try {
            return ResponseEntity.ok(administratorProfileService.getAdministratorList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasAuthority('Administrator')")
    @GetMapping("/{id}")
    public ResponseEntity<AdministratorProfile> getAdministratorById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(administratorProfileService.getAdministratorById(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasAuthority('Administrator')")
    @PatchMapping("/{id}")
    public ResponseEntity<AdministratorProfile> updateAdministratorProfile(@PathVariable Long id, @RequestBody AdministratorProfile updatedAdministratorProfile) {
        try {
            return ResponseEntity.ok(administratorProfileService.updateAdministratorProfile(id, updatedAdministratorProfile));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasAuthority('Administrator')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdministratorProfile(@PathVariable Long id) {
        try {
            administratorProfileService.deleteAdminProfileById(id);
            return ResponseEntity.ok("Profile deleted successfully...");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
