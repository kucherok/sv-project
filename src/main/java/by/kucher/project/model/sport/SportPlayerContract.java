package by.kucher.project.model.sport;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class SportPlayerContract implements Serializable {

	private static final long serialVersionUID = 6085405831302079783L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Version
	private int version;

	@Temporal(TemporalType.DATE)
	@NotNull
	private Date dateStart;

	@Temporal(TemporalType.DATE)
	@NotNull
	private Date dateFinish;

	private Integer price;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SportPlayerContract [id=" + id + ", version=" + version + ", dateStart=" + dateStart + ", dateFinish="
				+ dateFinish + ", price=" + price + "]";
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
	 * @return the dateStart
	 */
	public Date getDateStart() {
		return dateStart;
	}

	/**
	 * @param dateStart
	 *            the dateStart to set
	 */
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	/**
	 * @return the dateFinish
	 */
	public Date getDateFinish() {
		return dateFinish;
	}

	/**
	 * @param dateFinish
	 *            the dateFinish to set
	 */
	public void setDateFinish(Date dateFinish) {
		this.dateFinish = dateFinish;
	}

	/**
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

}
