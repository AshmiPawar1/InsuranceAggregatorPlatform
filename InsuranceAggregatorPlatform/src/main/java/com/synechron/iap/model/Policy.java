package com.synechron.iap.model;

import javax.annotation.Nonnegative;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="policy")
@EntityListeners(AuditingEntityListener.class)
public class Policy {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "policy_id")
	private Long id;
	
	@NotEmpty
	private String policyName;
	
	@NotEmpty
	private String policyProvider;
	
	@Nonnegative
	private Integer age;
	
	@NotEmpty
	private String city;
	
	@Nonnegative
	private Integer cost;

	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="policy_score_id")
	private PolicyScore policyscore;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="duration_and_premium_id")
	private DurationAndPremium durationPremium;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="policy_feature_id")
	private PolicyFeature policyFeature;
	
	public Policy() {
		
	}

	public Policy(Long id, @NotEmpty String policyName, @NotEmpty String policyProvider, @NotEmpty Integer age,
			@NotEmpty String city, @NotEmpty Integer cost, PolicyScore policyscore, DurationAndPremium durationPremium,
			PolicyFeature policyFeature) {
		super();
		this.id = id;
		this.policyName = policyName;
		this.policyProvider = policyProvider;
		this.age = age;
		this.city = city;
		this.cost = cost;
		this.policyscore = policyscore;
		this.durationPremium = durationPremium;
		this.policyFeature = policyFeature;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyProvider() {
		return policyProvider;
	}

	public void setPolicyProvider(String policyProvider) {
		this.policyProvider = policyProvider;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public PolicyScore getPolicyscore() {
		return policyscore;
	}

	public void setPolicyscore(PolicyScore policyscore) {
		this.policyscore = policyscore;
	}

	public DurationAndPremium getDurationPremium() {
		return durationPremium;
	}

	public void setDurationPremium(DurationAndPremium durationPremium) {
		this.durationPremium = durationPremium;
	}

	public PolicyFeature getPolicyFeature() {
		return policyFeature;
	}

	public void setPolicyFeature(PolicyFeature policyFeature) {
		this.policyFeature = policyFeature;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((durationPremium == null) ? 0 : durationPremium.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((policyFeature == null) ? 0 : policyFeature.hashCode());
		result = prime * result + ((policyName == null) ? 0 : policyName.hashCode());
		result = prime * result + ((policyProvider == null) ? 0 : policyProvider.hashCode());
		result = prime * result + ((policyscore == null) ? 0 : policyscore.hashCode());
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
		Policy other = (Policy) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (durationPremium == null) {
			if (other.durationPremium != null)
				return false;
		} else if (!durationPremium.equals(other.durationPremium))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (policyFeature == null) {
			if (other.policyFeature != null)
				return false;
		} else if (!policyFeature.equals(other.policyFeature))
			return false;
		if (policyName == null) {
			if (other.policyName != null)
				return false;
		} else if (!policyName.equals(other.policyName))
			return false;
		if (policyProvider == null) {
			if (other.policyProvider != null)
				return false;
		} else if (!policyProvider.equals(other.policyProvider))
			return false;
		if (policyscore == null) {
			if (other.policyscore != null)
				return false;
		} else if (!policyscore.equals(other.policyscore))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Policy [id=" + id + ", policyName=" + policyName + ", policyProvider=" + policyProvider + ", age=" + age
				+ ", city=" + city + ", cost=" + cost + ", policyscore=" + policyscore + ", durationPremium="
				+ durationPremium + ", policyFeature=" + policyFeature + "]";
	}

		
		
	

}
