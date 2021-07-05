package com.resume.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resume.app.dtos.skill.SkillDto;
import com.resume.app.mappers.SkillMapper;
import com.resume.app.repositories.SkillRepository;

@Service
public class SkillService {
	@Autowired
	private SkillRepository skillRepository;

	@Autowired
	private SkillMapper skillMapper;


	public List<SkillDto> getSkills() {
		return skillMapper.MapListToListDto(skillRepository.findAll());
	}
}
