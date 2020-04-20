package com.synechron.iap.model;

import javax.annotation.Nonnegative;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="duration_and_premium")
@EntityListeners(AuditingEntityListener.class)
public class DurationAndPremium {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Nonnegative
	private Integer durationYear;

	@Nonnegative
	private Integer premium;
	
	public DurationAndPremium() {
		
	}

	public DurationAndPremium(Long id, Integer durationYear, Integer premium) {
		super();
		this.id = id;
		this.durationYear = durationYear;
		this.premium = premium;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDurationYear() {
		return durationYear;
	}

	public void setDurationYear(Integer durationYear) {
		this.durationYear = durationYear;
	}

	public Integer getPremium() {
		return premium;
	}

	public void setPremium(Integer premium) {
		this.premium = premium;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((durationYear == null) ? 0 : durationYear.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((premium == null) ? 0 : premium.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DurationAndPremium other = (DurationAndPremium) obj;
		if (durationYear == null) {
			if (other.durationYear != null)
				return false;
		} else if (!durationYear.equals(other.durationYear))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (premium == null) {
			if (other.premium != null)
				return false;
		} else if (!premium.equals(other.premium))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DurationAndPremium [id=" + id + ", durationYear=" + durationYear + ", premium=" + premium + "]";
	}
	
	
	
}
