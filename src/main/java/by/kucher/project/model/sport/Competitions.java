package by.kucher.project.model.sport;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import by.kucher.project.model.common.PersistentObject;

@Entity
public class Competitions extends PersistentObject {

	private static final long serialVersionUID = 3186772630798225596L;

	@NotNull
	@Size(max = 128)
	private String name;

	private String responsible;

	private String regulation;

	@Enumerated(EnumType.ORDINAL)
	private CompetitionType competitionType;

	@ManyToOne
	private Sport sport;

	@Override
	public String toString() {
		return "Competitions [name=" + name + ", responsible=" + responsible + ", regulation=" + regulation
				+ ", competitionType=" + competitionType + ", sport=" + sport + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	public String getRegulation() {
		return regulation;
	}

	public void setRegulation(String regulation) {
		this.regulation = regulation;
	}

	public CompetitionType getCompetitionType() {
		return competitionType;
	}

	public void setCompetitionType(CompetitionType competitionType) {
		this.competitionType = competitionType;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

}
