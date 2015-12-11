package by.kucher.project.model.football;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import by.kucher.project.model.sport.SportTeam;

@Entity
public class FootballTeam extends SportTeam {

	private static final long serialVersionUID = -6828787812863102505L;

	@ManyToOne
	private FootballPlayer footballPlayer;

}
