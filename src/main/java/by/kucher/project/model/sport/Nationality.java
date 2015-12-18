package by.kucher.project.model.sport;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import by.kucher.project.model.common.PersistentObject;

@Entity
public class Nationality extends PersistentObject {

	private static final long serialVersionUID = 5531527386514745417L;

	@NotNull
	private String code;

	@NotNull
	private String name;

	private String language;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Nationality [code=" + code + ", name=" + name + ", language=" + language + "]";
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

}
