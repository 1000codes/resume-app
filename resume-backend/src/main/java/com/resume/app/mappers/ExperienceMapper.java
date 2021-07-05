package com.resume.app.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.resume.app.dtos.experience.ExperienceDto;
import com.resume.app.dtos.experience.ExperienceEditDto;
import com.resume.app.dtos.experience.ExperienceListDto;
import com.resume.app.entities.Experience;

@Component
public class ExperienceMapper {

	@Autowired
	private ModelMapper modelMapper;

	public ExperienceDto MapEntityToDto(Experience entity) {
		return modelMapper.map(entity, ExperienceDto.class);
	}
	
	public Experience MapEditDtoToEntity(ExperienceEditDto dto) {
		return modelMapper.map(dto, Experience.class);
	}

	public ExperienceEditDto MapEntityToEditDto(Experience entity) {
		return modelMapper.map(entity, ExperienceEditDto.class);
	}

	public List<ExperienceListDto> MapListToListDto(List<Experience> list) {
		List<ExperienceListDto> mappedList = list
				.stream()
				.map(this::convertToListDto)
				.collect(Collectors.toList());

		return mappedList;
	}

	private ExperienceListDto convertToListDto(Experience entity) {
		ExperienceListDto dto = modelMapper.map(entity, ExperienceListDto.class);

		return dto;
	}
}
