package com.project.collegedirectory.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity
@Data
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private DepartmentEntity departmentEntity;

    @ManyToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "id")
    private FacultyProfile facultyProfile;

    // One course can have many enrollments
    @OneToMany(mappedBy = "courseEntity")
    private Set<EnrollmentEntity> enrollmentEntities;
}

