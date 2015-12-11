package by.kucher.project.model.football;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import by.kucher.project.model.sport.SportPlayerContract;

@Entity
public class FootballContract extends SportPlayerContract {

	private static final long serialVersionUID = -5732606936080602173L;

	@Enumerated(EnumType.ORDINAL)
	private FootballContractType footballContractType;

}
