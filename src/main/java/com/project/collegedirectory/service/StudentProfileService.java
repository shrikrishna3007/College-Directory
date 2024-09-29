package com.project.collegedirectory.service;

import com.project.collegedirectory.entity.StudentProfile;
import com.project.collegedirectory.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentProfileService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentProfile createProfile(StudentProfile studentProfile) {
        return studentRepository.save(studentProfile);
    }


    public List<StudentProfile> getStudentProfiles() {
        return studentRepository.findAll();
    }


    public ResponseEntity<Optional<StudentProfile>> getStudentProfileById(Long id) {
        Optional<StudentProfile> studentProfile=studentRepository.findById(id);
        if(studentProfile.isPresent()){
            return ResponseEntity.ok(studentProfile);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<StudentProfile> updateStudentProfile(Long id, StudentProfile updatedProfile) {
        Optional<StudentProfile> studentProfileOptional = studentRepository.findById(id);
        if (studentProfileOptional.isPresent()) {
            StudentProfile studentProfile = studentProfileOptional.get();
            studentProfile.setPhoto(updatedProfile.getPhoto());
            studentProfile.setYear(updatedProfile.getYear());
            return ResponseEntity.ok(studentRepository.save(studentProfile));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public String deleteStudentProfile(Long id) {
        Optional<StudentProfile> studentProfileOptional = studentRepository.findById(id);
        if (studentProfileOptional.isPresent()) {
            studentRepository.deleteById(id);
            return "Student profile deleted successfully";
        } else {
            return "Student profile not found";
        }
    }
}
