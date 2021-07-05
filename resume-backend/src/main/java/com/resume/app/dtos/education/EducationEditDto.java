package com.resume.app.dtos.education;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EducationEditDto {

	private Long id;

	private String course;

	private String institution;

	private String degreeName;

	private Date startingDate;

	private Date completionDate;

	private String note;
}