package com.resume.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.resume.app.dtos.person.PersonDto;
import com.resume.app.dtos.person.PersonEditDto;
import com.resume.app.dtos.person.PersonListDto;
import com.resume.app.security.payload.response.MessageResponse;
import com.resume.app.services.PersonService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/person")
public class PersonController {
	@Autowired
	private PersonService personService;

	@PostMapping("/create")
	public ResponseEntity<PersonEditDto> create(@RequestBody PersonEditDto person) {
		PersonEditDto dto = personService.create(person);

		return ResponseEntity.ok(dto);
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<?> read(@PathVariable long id) {
		PersonDto result = personService.read(id);

		return ResponseEntity.ok(result);
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody PersonEditDto person) {
		PersonEditDto result = personService.update(person);

		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) {
		MessageResponse result = personService.delete(id);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/list")
	public ResponseEntity<?> list() {
		List<PersonListDto> list = personService.getPersons();

		return new ResponseEntity<List<PersonListDto>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/paging")
	public ResponseEntity<?> paging(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy) {

		List<PersonListDto> list = personService.getPersons(pageNo, pageSize, sortBy);

		return new ResponseEntity<List<PersonListDto>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<?> search(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "") String firstName) {

		List<PersonListDto> list = personService.searchPersons(pageNo, pageSize, firstName);

		return new ResponseEntity<List<PersonListDto>>(list, new HttpHeaders(), HttpStatus.OK);
	}
}
