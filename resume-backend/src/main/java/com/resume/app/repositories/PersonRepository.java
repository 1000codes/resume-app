package com.resume.app.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resume.app.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	Page<Person> findByFirstNameContaining(String firstName, Pageable pageable);

	Optional<Person> findByFirstNameAndLastNameAllIgnoreCase(String firstName, String lastName);
}
