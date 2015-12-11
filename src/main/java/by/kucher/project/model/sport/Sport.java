package by.kucher.project.model.sport;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import by.kucher.project.model.common.PersistentObject;

@Entity
public class Sport extends PersistentObject {

	private static final long serialVersionUID = 4490755161636336238L;

	@Size(min = 3, max = 64)
	private String name;

	private String Description;

	@ManyToOne
	private SportKind sportKind;

	@OneToMany(mappedBy = "sport")
	private Collection<Competitions> competitions;

	@Override
	public String toString() {
		return "Sport [name=" + name + ", Description=" + Description + ", sportKind=" + sportKind + ", competitions="
				+ competitions + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public SportKind getSportKind() {
		return sportKind;
	}

	public void setSportKind(SportKind sportKind) {
		this.sportKind = sportKind;
	}

	public Collection<Competitions> getCompetitions() {
		return competitions;
	}

	public void setCompetitions(Collection<Competitions> competitions) {
		this.competitions = competitions;
	}

}
