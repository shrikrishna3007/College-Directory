package com.project.collegedirectory.repository;

import com.project.collegedirectory.entity.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<EnrollmentEntity,Long> {
}
