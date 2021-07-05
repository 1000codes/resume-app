package com.resume.app.dtos.person;

import java.util.Date;
import java.util.List;

import com.resume.app.dtos.education.EducationDto;
import com.resume.app.dtos.experience.ExperienceDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDto {

	private Long id;

	private String firstName;

	private String lastName;

	private Date birthday;

	private String addres;

	private String email;

	private String telephone;

	private String mobile;
	
	//private List<SkillDto> skills;
	
	private List<ExperienceDto> experiences;
	
	private List<EducationDto> educations;
}