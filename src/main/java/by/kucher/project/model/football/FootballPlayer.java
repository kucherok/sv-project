package by.kucher.project.model.football;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import by.kucher.project.model.sport.SportPlayer;

@Entity
public class FootballPlayer extends SportPlayer {

	private static final long serialVersionUID = 8922635108632451516L;

	@Enumerated(EnumType.ORDINAL)
	private Position position;

	@OneToMany(mappedBy = "footballPlayer")
	private Collection<FootballTeam> footballTeam;

}
