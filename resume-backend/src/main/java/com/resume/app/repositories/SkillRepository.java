package com.resume.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resume.app.entities.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

}
