package com.resume.app.dtos.experience;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExperienceDto {
	
	private Long id;
	
	//private Long personId;
	
	private Boolean isCurrentJob;

	private Date startingDate;

	private Date endDate;

	private String jobTitle;

	private String comapnyName;

	private String jobLocation;

	private String description;
}