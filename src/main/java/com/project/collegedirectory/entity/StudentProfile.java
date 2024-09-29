package com.project.collegedirectory.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String photo;
    private String year;

    // One student can have many enrollments
    @OneToMany(mappedBy = "studentProfile")
    private Set<EnrollmentEntity> enrollmentEntities;
}

