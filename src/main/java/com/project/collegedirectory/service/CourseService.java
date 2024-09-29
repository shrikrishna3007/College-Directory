package com.project.collegedirectory.service;

import com.project.collegedirectory.entity.CourseEntity;
import com.project.collegedirectory.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public ResponseEntity<CourseEntity> addCourse(CourseEntity courseEntity) {
        try {
            return ResponseEntity.ok(courseRepository.save(courseEntity));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<List<CourseEntity>> getCourseList() {
        try {
            return ResponseEntity.ok(courseRepository.findAll());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<CourseEntity> getCourseById(Long id) {
        Optional<CourseEntity> courseEntity=courseRepository.findById(id);
        if(courseEntity.isPresent()) {
            return ResponseEntity.ok(courseEntity.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<CourseEntity> updateCourse(Long id, CourseEntity updatedCourseEntity) {
        Optional<CourseEntity> courseEntity=courseRepository.findById(id);
        if(courseEntity.isPresent()) {
            CourseEntity course = courseEntity.get();
            course.setDescription(updatedCourseEntity.getDescription());
            course.setTitle(updatedCourseEntity.getTitle());
            return ResponseEntity.ok(courseRepository.save(course));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public String deleteCourse(Long id) {
        Optional<CourseEntity> courseEntity=courseRepository.findById(id);
        if(courseEntity.isPresent()) {
            courseRepository.deleteById(id);
            return "Course deleted successfully";
        } else {
            return "Course not found";
        }
    }
}
