package com.resume.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resume.app.dtos.skill.SkillDto;
import com.resume.app.services.SkillService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/skill")
public class SkillController {
	@Autowired
	private SkillService skillService;

	@GetMapping("/list")
	public ResponseEntity<?> list() {
		List<SkillDto> list = skillService.getSkills();

		return new ResponseEntity<List<SkillDto>>(list, new HttpHeaders(), HttpStatus.OK);
	}
}
