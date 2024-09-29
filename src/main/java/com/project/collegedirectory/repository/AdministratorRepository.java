package com.project.collegedirectory.repository;

import com.project.collegedirectory.entity.AdministratorProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<AdministratorProfile,Long> {
}
