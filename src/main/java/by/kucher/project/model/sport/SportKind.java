package by.kucher.project.model.sport;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import by.kucher.project.model.common.PersistentObject;

@Entity
public class SportKind extends PersistentObject {

	private static final long serialVersionUID = -7894829465522585660L;

	@NotNull
	@Size(min = 3, max = 64)
	private String name;

	@Temporal(TemporalType.DATE)
	private Date dateStart;

	private String description;

	@Enumerated(EnumType.ORDINAL)
	private SportKindCategory sportKindCategory;

	@OneToMany(mappedBy = "sportKind")
	private Collection<Sport> sports;

	@Override
	public String toString() {
		return "SportKind [name=" + name + ", dateStart=" + dateStart + ", description=" + description
				+ ", sportKindCategory=" + sportKindCategory + ", sports=" + sports + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SportKindCategory getSportKindCategory() {
		return sportKindCategory;
	}

	public void setSportKindCategory(SportKindCategory sportKindCategory) {
		this.sportKindCategory = sportKindCategory;
	}

	public Collection<Sport> getSports() {
		return sports;
	}

	public void setSports(Collection<Sport> sports) {
		this.sports = sports;
	}

}
