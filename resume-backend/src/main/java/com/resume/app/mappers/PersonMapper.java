package com.resume.app.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.resume.app.dtos.person.PersonDto;
import com.resume.app.dtos.person.PersonEditDto;
import com.resume.app.dtos.person.PersonListDto;
import com.resume.app.entities.Person;

@Component
public class PersonMapper {

	@Autowired
	private ModelMapper modelMapper;

	public PersonDto MapEntityToDto(Person entity) {
		return modelMapper.map(entity, PersonDto.class);
	}
	
	public Person MapEditDtoToEntity(PersonEditDto dto) {
		return modelMapper.map(dto, Person.class);
	}

	public PersonEditDto MapEntityToEditDto(Person entity) {
		return modelMapper.map(entity, PersonEditDto.class);
	}

	public List<PersonListDto> MapListToListDto(List<Person> list) {
		List<PersonListDto> mappedList = list
				.stream()
				.map(this::convertToListDto)
				.collect(Collectors.toList());

		return mappedList;
	}

	private PersonListDto convertToListDto(Person entity) {
		PersonListDto dto = modelMapper.map(entity, PersonListDto.class);

		return dto;
	}
}
