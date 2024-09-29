package com.project.collegedirectory.controller;

import com.project.collegedirectory.entity.CourseEntity;
import com.project.collegedirectory.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/details")
    public ResponseEntity<CourseEntity> addCourse(@RequestBody CourseEntity courseEntity) {
        try {
            return courseService.addCourse(courseEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasAuthority('Administrator')")
    @GetMapping("/list")
    public ResponseEntity<List<CourseEntity>> getCourseList() {
        try {
            return courseService.getCourseList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseEntity> getCourseById(@PathVariable Long id) {
        try {
            return courseService.getCourseById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CourseEntity> updateCourse(@PathVariable Long id, @RequestBody CourseEntity updatedCourseEntity) {
        try {
            return courseService.updateCourse(id, updatedCourseEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        try {
            courseService.deleteCourse(id);
            return ResponseEntity.ok("Course deleted successfully...");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
