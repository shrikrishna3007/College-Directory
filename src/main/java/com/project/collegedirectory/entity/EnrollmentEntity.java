package com.project.collegedirectory.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class EnrollmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many enrollments can have one student
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private StudentProfile studentProfile;

    // Many enrollments can have one course
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private CourseEntity courseEntity;
}

