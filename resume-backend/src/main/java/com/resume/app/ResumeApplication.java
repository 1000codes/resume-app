package com.resume.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.resume.app.repositories.PersonRepository;
import com.resume.app.repositories.UserRepository;

@SpringBootApplication
public class ResumeApplication {

	@Autowired
	private PersonRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ResumeApplication.class, args);
	}

}
