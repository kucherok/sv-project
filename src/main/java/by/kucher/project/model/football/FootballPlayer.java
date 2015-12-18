package by.kucher.project.model.football;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import by.kucher.project.model.sport.Nationality;
import by.kucher.project.model.sport.SportPlayer;

@Entity
public class FootballPlayer extends SportPlayer {

	private static final long serialVersionUID = 8922635108632451516L;

	@Enumerated(EnumType.ORDINAL)
	private Position position;

	@Enumerated(EnumType.ORDINAL)
	private FootballTeamNumber footballTeamNumber;

	@OneToMany
	private Collection<Nationality> nationality;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(joinColumns = @JoinColumn(name = "footballPlayer_id") , inverseJoinColumns = @JoinColumn(name = "footballTeam_id") )
	private Collection<FootballTeam> footballTeam;

	@Override
	public String toString() {
		return "FootballPlayer [position=" + position + ", footballTeamNumber=" + footballTeamNumber + ", footballTeam="
				+ footballTeam + "]";
	}

	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * @return the footballTeamNumber
	 */
	public FootballTeamNumber getFootballTeamNumber() {
		return footballTeamNumber;
	}

	/**
	 * @param footballTeamNumber
	 *            the footballTeamNumber to set
	 */
	public void setFootballTeamNumber(FootballTeamNumber footballTeamNumber) {
		this.footballTeamNumber = footballTeamNumber;
	}

	/**
	 * @return the footballTeam
	 */
	public Collection<FootballTeam> getFootballTeam() {
		return footballTeam;
	}

	/**
	 * @param footballTeam
	 *            the footballTeam to set
	 */
	public void setFootballTeam(Collection<FootballTeam> footballTeam) {
		this.footballTeam = footballTeam;
	}

}
