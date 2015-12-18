package by.kucher.project.model.hokey;

import javax.persistence.Entity;
import javax.persistence.Table;

import by.kucher.project.model.sport.SportPlayer;

@Entity
@Table(name = "hokey_player")
public class Player extends SportPlayer {

	private static final long serialVersionUID = -2546979354615699174L;

}
