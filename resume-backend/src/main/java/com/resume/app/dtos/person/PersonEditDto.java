package com.resume.app.dtos.person;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonEditDto {

	private Long id;

	private String firstName;

	private String lastName;

	private Date birthday;

	private String addres;

	private String email;

	private String telephone;

	private String mobile;
}