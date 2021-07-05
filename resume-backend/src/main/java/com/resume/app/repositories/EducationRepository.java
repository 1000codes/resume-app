package com.resume.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resume.app.entities.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {

}
