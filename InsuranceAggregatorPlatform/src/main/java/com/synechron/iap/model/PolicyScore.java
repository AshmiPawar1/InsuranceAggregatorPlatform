package com.synechron.iap.model;

import javax.annotation.Nonnegative;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="policy_score")
@EntityListeners(AuditingEntityListener.class)
public class PolicyScore {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Nonnegative
	private Integer premiumScore;
	
	@Nonnegative
	private Integer claimSettelementRatioScore;
	
	@Nonnegative
	private Integer benifitsScore;
	
	@Nonnegative
	private Integer totalScore;
	
	public PolicyScore() {
		
	}

	public PolicyScore(Long id, @NotEmpty Integer premiumScore, @NotEmpty Integer claimSettelementRatioScore,
			@NotEmpty Integer benifitsScore, @NotEmpty Integer totalScore) {
		super();
		this.id = id;
		this.premiumScore = premiumScore;
		this.claimSettelementRatioScore = claimSettelementRatioScore;
		this.benifitsScore = benifitsScore;
		this.totalScore = totalScore;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPremiumScore() {
		return premiumScore;
	}

	public void setPremiumScore(Integer premiumScore) {
		this.premiumScore = premiumScore;
	}

	public Integer getClaimSettelementRatioScore() {
		return claimSettelementRatioScore;
	}

	public void setClaimSettelementRatioScore(Integer claimSettelementRatioScore) {
		this.claimSettelementRatioScore = claimSettelementRatioScore;
	}

	public Integer getBenifitsScore() {
		return benifitsScore;
	}

	public void setBenifitsScore(Integer benifitsScore) {
		this.benifitsScore = benifitsScore;
	}

	public Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((benifitsScore == null) ? 0 : benifitsScore.hashCode());
		result = prime * result + ((claimSettelementRatioScore == null) ? 0 : claimSettelementRatioScore.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((premiumScore == null) ? 0 : premiumScore.hashCode());
		result = prime * result + ((totalScore == null) ? 0 : totalScore.hashCode());
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
		PolicyScore other = (PolicyScore) obj;
		if (benifitsScore == null) {
			if (other.benifitsScore != null)
				return false;
		} else if (!benifitsScore.equals(other.benifitsScore))
			return false;
		if (claimSettelementRatioScore == null) {
			if (other.claimSettelementRatioScore != null)
				return false;
		} else if (!claimSettelementRatioScore.equals(other.claimSettelementRatioScore))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (premiumScore == null) {
			if (other.premiumScore != null)
				return false;
		} else if (!premiumScore.equals(other.premiumScore))
			return false;
		if (totalScore == null) {
			if (other.totalScore != null)
				return false;
		} else if (!totalScore.equals(other.totalScore))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PolicyScore [id=" + id + ", premiumScore=" + premiumScore + ", claimSettelementRatioScore="
				+ claimSettelementRatioScore + ", benifitsScore=" + benifitsScore + ", totalScore=" + totalScore + "]";
	}
	
	

}
