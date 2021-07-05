package com.resume.app.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.resume.app.dtos.skill.SkillDto;
import com.resume.app.entities.Skill;

@Component
public class SkillMapper {

	@Autowired
	private ModelMapper modelMapper;

	public Skill MapDtoToEntity(SkillDto dto) {
		return modelMapper.map(dto, Skill.class);
	}
	
	public List<SkillDto> MapListToListDto(List<Skill> list) {
		List<SkillDto> mappedList = list
				.stream()
				.map(this::convertToListDto)
				.collect(Collectors.toList());

		return mappedList;
	}

	private SkillDto convertToListDto(Skill entity) {
		SkillDto dto = modelMapper.map(entity, SkillDto.class);

		return dto;
	}
}
