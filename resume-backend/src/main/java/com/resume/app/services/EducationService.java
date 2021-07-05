package com.resume.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resume.app.dtos.education.EducationDto;
import com.resume.app.dtos.education.EducationEditDto;
import com.resume.app.entities.Education;
import com.resume.app.exceptions.NotFoundException;
import com.resume.app.mappers.EducationMapper;
import com.resume.app.repositories.EducationRepository;
import com.resume.app.security.payload.response.MessageResponse;
import com.resume.app.utils.Constants;

@Service
public class EducationService {
	@Autowired
	private EducationRepository educationRepository;

	@Autowired
	private EducationMapper educationMapper;

	/* Region - CRUD */

	/**
	 * Create a education
	 * 
	 * @param dto
	 * @return
	 */
	public EducationEditDto create(EducationEditDto dto) {
		Education entity = educationMapper.MapEditDtoToEntity(dto);

		return educationMapper.MapEntityToEditDto(educationRepository.save(entity));
	}

	/**
	 * Read a education
	 * 
	 * @param id
	 * @return
	 */
	public EducationDto read(Long id) {
		Education entity = educationRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format(Constants.MESSAGE_ELEMENT_NOT_FOUND, id)));

		return educationMapper.MapEntityToDto(entity);
	}

	/**
	 * Update a education
	 * 
	 * @param dto
	 * @return
	 */
	public EducationEditDto update(EducationEditDto dto) {

		Education entity = educationRepository.findById(dto.getId()).orElseThrow(
				() -> new NotFoundException(String.format(Constants.MESSAGE_ELEMENT_NOT_FOUND, dto.getId())));

		return educationMapper.MapEntityToEditDto(educationRepository.save(entity));
	}

	/**
	 * Delete a education
	 * 
	 * @param id
	 */
	public MessageResponse delete(long id) {
		educationRepository.deleteById(id);

		Education entity = educationRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format(Constants.MESSAGE_ELEMENT_NOT_FOUND, id)));

		educationRepository.deleteById(entity.getId());

		return new MessageResponse(String.format(Constants.MESSAGE_ELEMENT_DELETED_SUCCESS, Education.class.getName()));
	}

	/* End Region */
}
