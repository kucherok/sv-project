package by.kucher.project.model.football;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import by.kucher.project.model.sport.SportTeam;

@Entity
public class FootballTeam extends SportTeam {

	private static final long serialVersionUID = -6828787812863102505L;

	private String owner;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "footballTeam")
	private Collection<FootballPlayer> footballPlayer;

	@Override
	public String toString() {
		return "FootballTeam [owner=" + owner + ", footballPlayer=" + footballPlayer + "]";
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner
	 *            the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the footballPlayer
	 */
	public Collection<FootballPlayer> getFootballPlayer() {
		return footballPlayer;
	}

	/**
	 * @param footballPlayer
	 *            the footballPlayer to set
	 */
	public void setFootballPlayer(Collection<FootballPlayer> footballPlayer) {
		this.footballPlayer = footballPlayer;
	}

}
