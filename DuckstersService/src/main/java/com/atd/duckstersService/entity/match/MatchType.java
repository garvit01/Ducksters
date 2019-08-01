package com.atd.duckstersService.entity.match;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.atd.duckstersService.entity.common.CommonParametersEmbaddable;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class MatchType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name = "match_type")
	private String type;

	@Column
	private int totalOvers;

	@ManyToOne
	@JoinColumn(name = "match_id", nullable = false)
	@JsonBackReference
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Match matches;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "isActive", column = @Column(name = "isActive")),
			@AttributeOverride(name = "createdAt", column = @Column(name = "createdAt")),
			@AttributeOverride(name = "lastModified", column = @Column(name = "lastModified")),
			@AttributeOverride(name = "isVerified", column = @Column(name = "isVerified"))})
	private CommonParametersEmbaddable commonParametersEmbaddable;

	public MatchType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MatchType(int id, String type, int totalOvers, Match matches,
			CommonParametersEmbaddable commonParametersEmbaddable) {
		super();
		this.id = id;
		this.type = type;
		this.totalOvers = totalOvers;
		this.matches = matches;
		this.commonParametersEmbaddable = commonParametersEmbaddable;
	}

	public Match getMatches() {
		return matches;
	}

	public void setMatches(Match matches) {
		this.matches = matches;
	}

	public CommonParametersEmbaddable getCommonParametersEmbaddable() {
		return commonParametersEmbaddable;
	}

	public void setCommonParametersEmbaddable(CommonParametersEmbaddable commonParametersEmbaddable) {
		this.commonParametersEmbaddable = commonParametersEmbaddable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTotalOvers() {
		return totalOvers;
	}

	public void setTotalOvers(int totalOvers) {
		this.totalOvers = totalOvers;
	}


}
