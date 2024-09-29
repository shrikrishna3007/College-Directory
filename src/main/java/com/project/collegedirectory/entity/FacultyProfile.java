package com.project.collegedirectory.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FacultyProfile {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private UserEntity userEntity;
    private String photo;
    private int office_hours;
    @ManyToOne
    @JoinColumn(name = "department_id",referencedColumnName = "id")
    private DepartmentEntity departmentEntity;
}
