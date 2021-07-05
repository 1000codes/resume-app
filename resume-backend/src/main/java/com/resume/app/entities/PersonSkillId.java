
package com.resume.app.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Embeddable
@Getter
@Setter
public class PersonSkillId implements Serializable{

	@Column(name = "person_id")
	private Long personId;

	@Column(name = "skill_id")
	private Long skillId;

	public PersonSkillId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PersonSkillId(Long personId, Long skillId) {
		this.personId = personId;
		this.skillId = skillId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		PersonSkillId that = (PersonSkillId) o;
		return Objects.equals(personId, that.personId) && Objects.equals(skillId, that.skillId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(personId, skillId);
	}
}
