package by.kucher.project.model.sport;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class SportTeam implements Serializable {

	private static final long serialVersionUID = 3746756877532368143L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Version
	private int version;

	@NotNull
	private String name;

	private String shortName;

	@Enumerated(EnumType.ORDINAL)
	private Gender gender;

	private String countryCode;

	@Temporal(TemporalType.DATE)
	private Date foundingDate;

	private String manager;

	@Lob
	private byte[] logo;

	@Override
	public String toString() {
		return "SportTeam [id=" + id + ", version=" + version + ", name=" + name + ", shortName=" + shortName
				+ ", gender=" + gender + ", countryCode=" + countryCode + ", foundingDate=" + foundingDate
				+ ", manager=" + manager + ", logo=" + Arrays.toString(logo) + "]";
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
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
	 * @return the shortName
	 */
	public String getShortName() {
		return shortName;
	}

	/**
	 * @param shortName
	 *            the shortName to set
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode
	 *            the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the foundingDate
	 */
	public Date getFoundingDate() {
		return foundingDate;
	}

	/**
	 * @param foundingDate
	 *            the foundingDate to set
	 */
	public void setFoundingDate(Date foundingDate) {
		this.foundingDate = foundingDate;
	}

	/**
	 * @return the manager
	 */
	public String getManager() {
		return manager;
	}

	/**
	 * @param manager
	 *            the manager to set
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}

	/**
	 * @return the logo
	 */
	public byte[] getLogo() {
		return logo;
	}

	/**
	 * @param logo
	 *            the logo to set
	 */
	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

}
