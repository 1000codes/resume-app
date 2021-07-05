
package com.resume.app.entities;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "person_skills")
@Getter
@Setter
public class PersonSkill {

	@EmbeddedId
	private PersonSkillId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("person_id")
	private Person person;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("skill_id")
	private Skill skill;
	
	private Integer level;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		PersonSkill that = (PersonSkill) o;
		return Objects.equals(person, that.person) && Objects.equals(skill, that.skill);
	}

	@Override
	public int hashCode() {
		return Objects.hash(person, skill);
	}
}
