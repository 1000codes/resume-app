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

import com.resume.app.dtos.education.EducationDto;
import com.resume.app.dtos.education.EducationEditDto;
import com.resume.app.security.payload.response.MessageResponse;
import com.resume.app.services.EducationService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/education")
public class EducationController {
	@Autowired
	private EducationService educationService;

	@PostMapping("/create")
	public ResponseEntity<EducationEditDto> create(@RequestBody EducationEditDto education) {
		EducationEditDto dto = educationService.create(education);

		return ResponseEntity.ok(dto);
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<?> read(@PathVariable long id) {
		EducationDto result = educationService.read(id);

		return ResponseEntity.ok(result);
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody EducationEditDto education) {
		EducationEditDto result = educationService.update(education);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) {
		MessageResponse result = educationService.delete(id);

		return ResponseEntity.ok(result);
	}
}
