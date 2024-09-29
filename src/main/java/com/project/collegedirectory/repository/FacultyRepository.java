package com.project.collegedirectory.repository;

import com.project.collegedirectory.entity.FacultyProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<FacultyProfile,Long> {
}
