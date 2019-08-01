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
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.atd.duckstersService.entity.common.CommonParametersEmbaddable;
import com.atd.duckstersService.entity.team.Team;
import com.atd.duckstersService.entity.user.UserProfile;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "matches")
public class Match {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column
	private String place;

	@Column
	private String scorerName;

//	@OneToMany(mappedBy = "matches", cascade = CascadeType.ALL)
//	@JsonManagedReference
//	private List<MatchType> listMatchTypes;
//
//	@OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
//	@JsonManagedReference
//	private List<MatchInningTeam> listMatchInningTeam;
//
//	 @OneToMany(mappedBy = "matchForAwards", cascade = CascadeType.ALL)
//	 @JsonManagedReference
//	 private List<MatchAward> listMatchAwards;
//
//	@OneToMany(mappedBy = "matchOfThisOver", cascade = CascadeType.ALL)
//	@JsonManagedReference
//	private List<Over> listOvers;

	@ManyToOne
	@JoinColumn(name = "winner_team_id", nullable = true)
	@JsonBackReference
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Team winnerTeam;

	@ManyToOne
	@JoinColumn(name = "organizer_id", nullable = false)
	@JsonBackReference
	@OnDelete(action = OnDeleteAction.CASCADE)
	private UserProfile organizer;
	
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "isActive", column = @Column(name = "isActive")),
			@AttributeOverride(name = "createdAt", column = @Column(name = "createdAt")),
			@AttributeOverride(name = "lastModified", column = @Column(name = "lastModified")),
			@AttributeOverride(name = "isVerified", column = @Column(name = "isVerified")) })
	private CommonParametersEmbaddable commonParametersEmbaddable;

	public Match() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getScorerName() {
		return scorerName;
	}

	public void setScorerName(String scorerName) {
		this.scorerName = scorerName;
	}

	public UserProfile getOrganizer() {
		return organizer;
	}

	public void setOrganizer(UserProfile organizer) {
		this.organizer = organizer;
	}

//	public List<MatchInningTeam> getMatchInningTeam() {
//		return listMatchInningTeam;
//	}
//
//	public void setMatchInningTeam(List<MatchInningTeam> matchInningTeam) {
//		this.listMatchInningTeam = matchInningTeam;
//	}

	public Team getWinnerTeam() {
		return winnerTeam;
	}

	public void setWinnerTeam(Team winnerTeam) {
		this.winnerTeam = winnerTeam;
	}

	// public List<MatchAward> getMatchAwards() {
	// return listMatchAwards;
	// }
	//
	// public void setMatchAwards(List<MatchAward> matchAwards) {
	// this.listMatchAwards = matchAwards;
	// }

//	public List<Over> getListOvers() {
//		return listOvers;
//	}
//
//	public void setListOvers(List<Over> listOvers) {
//		this.listOvers = listOvers;
//	}

	public CommonParametersEmbaddable getCommonParametersEmbaddable() {
		return commonParametersEmbaddable;
	}

	public void setCommonParametersEmbaddable(CommonParametersEmbaddable commonParametersEmbaddable) {
		this.commonParametersEmbaddable = commonParametersEmbaddable;
	}
//
//	public List<MatchType> getListMatchTypes() {
//		return listMatchTypes;
//	}
//
//	public void setListMatchTypes(List<MatchType> listMatchTypes) {
//		this.listMatchTypes = listMatchTypes;
//	}
//
//	public List<MatchInningTeam> getListMatchInningTeam() {
//		return listMatchInningTeam;
//	}
//
//	public void setListMatchInningTeam(List<MatchInningTeam> listMatchInningTeam) {
//		this.listMatchInningTeam = listMatchInningTeam;
//	}

}
