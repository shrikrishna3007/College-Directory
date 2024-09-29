package com.project.collegedirectory.controller;

import com.project.collegedirectory.entity.DepartmentEntity;
import com.project.collegedirectory.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@CrossOrigin
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/details")
    public ResponseEntity<DepartmentEntity> createDepartment(@RequestBody DepartmentEntity departmentEntity){
        try {
            departmentService.createDepartment(departmentEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(departmentEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasAuthority('Administrator')")
    @GetMapping("/list")
    public ResponseEntity<List<DepartmentEntity>> getDepartmentList(){
        try {
            return departmentService.getDepartmentList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentEntity> getDepartmentById(@PathVariable Long id){
        try {
            return departmentService.getDepartmentById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentEntity> updateDepartment(@PathVariable Long id, @RequestBody DepartmentEntity updatedDepartmentEntity){
        try {
            return ResponseEntity.ok(departmentService.updateDepartment(id, updatedDepartmentEntity));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
