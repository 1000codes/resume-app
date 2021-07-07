package com.resume.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.resume.app.dtos.person.PersonDto;
import com.resume.app.dtos.person.PersonEditDto;
import com.resume.app.dtos.person.PersonListDto;
import com.resume.app.entities.Person;
import com.resume.app.exceptions.BadRequestException;
import com.resume.app.exceptions.NotFoundException;
import com.resume.app.mappers.PersonMapper;
import com.resume.app.repositories.PersonRepository;
import com.resume.app.security.payload.response.MessageResponse;
import com.resume.app.utils.Constants;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private PersonMapper personMapper;

	/* Region - CRUD */

	/**
	 * Create a person
	 * 
	 * @param dto
	 * @return
	 */
	public PersonEditDto create(PersonEditDto dto) {

		 personRepository.findByFirstNameAndLastNameAllIgnoreCase(dto.getFirstName(), dto.getLastName())
		 .ifPresent(s -> {
		 		throw  new BadRequestException(String.format(Constants.MESSAGE_PERSON_EXISTS, dto.getFirstName(), dto.getLastName()));
		 		}
		 );

		Person entity = personMapper.MapEditDtoToEntity(dto);

		return personMapper.MapEntityToEditDto(personRepository.save(entity));
	}

	/**
	 * Read a person
	 * 
	 * @param id
	 * @return
	 */
	public PersonDto read(Long id) {

		Person entity = personRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format(Constants.MESSAGE_ELEMENT_NOT_FOUND, id)));

		return personMapper.MapEntityToDto(entity);
	}

	/**
	 * Update a person
	 * 
	 * @param dto
	 * @return
	 */
	public PersonEditDto update(PersonEditDto dto) {

		Person entity = personRepository.findById(dto.getId()).orElseThrow(
				() -> new NotFoundException(String.format(Constants.MESSAGE_ELEMENT_NOT_FOUND, dto.getId())));

		entity = personMapper.MapEditDtoToEntity(dto);

		
		return personMapper.MapEntityToEditDto(personRepository.save(entity));
	}

	/**
	 * Delete a person
	 * 
	 * @param id
	 */
	public MessageResponse delete(long id) {

		Person entity = personRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format(Constants.MESSAGE_ELEMENT_NOT_FOUND, id)));

		personRepository.deleteById(entity.getId());

		return new MessageResponse(String.format(Constants.MESSAGE_ELEMENT_DELETED_SUCCESS, Person.class.getName()));
	}

	/* End Region */

	public List<PersonListDto> getPersons() {
		return personMapper.MapListToListDto(personRepository.findAll());
	}

	public List<PersonListDto> getPersons(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<Person> pagedResult = personRepository.findAll(paging);

		if (pagedResult.hasContent()) {
			return personMapper.MapListToListDto(pagedResult.getContent());
		} else {
			return new ArrayList<PersonListDto>();
		}
	}

	public List<PersonListDto> searchPersons(Integer pageNo, Integer pageSize, String firstName) {
		Pageable paging = PageRequest.of(pageNo, pageSize);

		Page<Person> pagedResult = personRepository.findByFirstNameContaining(firstName, paging);

		if (pagedResult.hasContent()) {
			return personMapper.MapListToListDto(pagedResult.getContent());
		} else {
			return new ArrayList<PersonListDto>();
		}
	}
}
