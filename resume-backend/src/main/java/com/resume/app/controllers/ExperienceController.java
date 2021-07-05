package com.resume.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resume.app.dtos.experience.ExperienceDto;
import com.resume.app.dtos.experience.ExperienceEditDto;
import com.resume.app.security.payload.response.MessageResponse;
import com.resume.app.services.ExperienceService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/experience")
public class ExperienceController {
	@Autowired
	private ExperienceService experienceService;

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody ExperienceEditDto experience) {
		ExperienceEditDto dto = experienceService.create(experience);

		return ResponseEntity.ok(dto);
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<?> read(@PathVariable long id) {
		ExperienceDto result = experienceService.read(id);

		return ResponseEntity.ok(result);
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody ExperienceEditDto experience) {
		ExperienceEditDto result = experienceService.update(experience);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) {
		MessageResponse result = experienceService.delete(id);

		return ResponseEntity.ok(result);
	}
}
