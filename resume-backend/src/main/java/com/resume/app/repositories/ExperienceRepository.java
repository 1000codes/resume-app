package com.resume.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resume.app.entities.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {

}
