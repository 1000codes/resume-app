package com.resume.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resume.app.dtos.experience.ExperienceDto;
import com.resume.app.dtos.experience.ExperienceEditDto;
import com.resume.app.entities.Experience;
import com.resume.app.exceptions.NotFoundException;
import com.resume.app.mappers.ExperienceMapper;
import com.resume.app.repositories.ExperienceRepository;
import com.resume.app.security.payload.response.MessageResponse;
import com.resume.app.utils.Constants;

@Service
public class ExperienceService {
	@Autowired
	private ExperienceRepository experienceRepository;

	@Autowired
	private ExperienceMapper experienceMapper;

	/* Region - CRUD */

	/**
	 * Create a experience
	 * 
	 * @param dto
	 * @return
	 */
	public ExperienceEditDto create(ExperienceEditDto dto) {
		Experience entity = experienceMapper.MapEditDtoToEntity(dto);

		return experienceMapper.MapEntityToEditDto(experienceRepository.save(entity));
	}

	/**
	 * Read a experience
	 * 
	 * @param id
	 * @return
	 */
	public ExperienceDto read(Long id) {
		Experience entity = experienceRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format(Constants.MESSAGE_ELEMENT_NOT_FOUND, id)));

		return experienceMapper.MapEntityToDto(entity);
	}

	/**
	 * Update a experience
	 * 
	 * @param dto
	 * @return
	 */
	public ExperienceEditDto update(ExperienceEditDto dto) {

		Experience entity = experienceRepository.findById(dto.getId()).orElseThrow(
				() -> new NotFoundException(String.format(Constants.MESSAGE_ELEMENT_NOT_FOUND, dto.getId())));

		return experienceMapper.MapEntityToEditDto(experienceRepository.save(entity));
	}

	/**
	 * Delete a experience
	 * 
	 * @param id
	 */
	public MessageResponse delete(long id) {

		Experience entity = experienceRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format(Constants.MESSAGE_ELEMENT_NOT_FOUND, id)));

		experienceRepository.deleteById(entity.getId());

		return new MessageResponse(
				String.format(Constants.MESSAGE_ELEMENT_DELETED_SUCCESS, Experience.class.getName()));
	}

	/* End Region */
}
