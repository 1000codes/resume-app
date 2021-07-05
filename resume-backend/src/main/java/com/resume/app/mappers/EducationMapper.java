package com.resume.app.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.resume.app.dtos.education.EducationDto;
import com.resume.app.dtos.education.EducationEditDto;
import com.resume.app.dtos.education.EducationListDto;
import com.resume.app.entities.Education;

@Component
public class EducationMapper {

	@Autowired
	private ModelMapper modelMapper;

	public EducationDto MapEntityToDto(Education entity) {
		return modelMapper.map(entity, EducationDto.class);
	}
	
	public Education MapEditDtoToEntity(EducationEditDto dto) {
		return modelMapper.map(dto, Education.class);
	}

	public EducationEditDto MapEntityToEditDto(Education entity) {
		return modelMapper.map(entity, EducationEditDto.class);
	}

	public List<EducationListDto> MapListToListDto(List<Education> list) {
		List<EducationListDto> mappedList = list
				.stream()
				.map(this::convertToListDto)
				.collect(Collectors.toList());

		return mappedList;
	}

	private EducationListDto convertToListDto(Education entity) {
		EducationListDto dto = modelMapper.map(entity, EducationListDto.class);

		return dto;
	}
}
