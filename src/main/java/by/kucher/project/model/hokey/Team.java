package by.kucher.project.model.hokey;

import javax.persistence.Entity;
import javax.persistence.Table;

import by.kucher.project.model.sport.SportTeam;

@Entity
@Table(name = "hokeyTeam")
public class Team extends SportTeam {

	private static final long serialVersionUID = 104855665700651030L;

}
