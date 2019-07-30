package com.atd.duckstersService.entity.team;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.atd.duckstersService.entity.common.CommonParametersEmbaddable;
import com.atd.duckstersService.entity.match.Match;
import com.atd.duckstersService.entity.match.MatchInningTeam;
import com.atd.duckstersService.entity.tournament.Tournament;
import com.atd.duckstersService.entity.tournament.TournamentTeam;
import com.atd.duckstersService.entity.user.UserProfile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Team {

	@Id
	private int id;

	@Column
	private String name;

	@Column
	private String coverPhoto;

//	@OneToMany(mappedBy = "joinedTeams", cascade = CascadeType.ALL)
//	@JsonManagedReference
//	private List<TournamentTeam> listTournaments;

//	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
//	@JsonManagedReference
//	private List<MatchInningTeam> listMatchInningTeam;

//	@OneToMany(mappedBy = "winnerTeam", cascade = CascadeType.ALL)
//	@JsonManagedReference
//	private List<Match> listWinningMatches;

//	@OneToMany(mappedBy = "tournamentWinnerTeam", cascade = CascadeType.ALL)
//	@JsonManagedReference
//	private List<Tournament> listWinningTournament;

//	 @OneToMany(mappedBy = "teamMap", cascade = CascadeType.ALL)
//	 @JsonManagedReference
//	 private List<TeamUser> teamUser;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "isActive", column = @Column(name = "isActive")),
			@AttributeOverride(name = "createdAt", column = @Column(name = "createdAt")),
			@AttributeOverride(name = "lastModified", column = @Column(name = "lastModified")),
			@AttributeOverride(name = "isVerified", column = @Column(name = "isVerified")) })
	private CommonParametersEmbaddable commonParametersEmbaddable;


	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoverPhoto() {
		return coverPhoto;
	}

	public void setCoverPhoto(String coverPhoto) {
		this.coverPhoto = coverPhoto;
	}

//	public List<TournamentTeam> getListTournaments() {
//		return listTournaments;
//	}
//
//	public void setListTournaments(List<TournamentTeam> listTournaments) {
//		this.listTournaments = listTournaments;
//	}

//	public List<MatchInningTeam> getMatchInningTeam() {
//		return listMatchInningTeam;
//	}
//
//	public void setMatchInningTeam(List<MatchInningTeam> matchInningTeam) {
//		this.listMatchInningTeam = matchInningTeam;
//	}

//	 public List<TeamUser> getTeamUser() {
//	 return teamUser;
//	 }
//	
//	 public void setTeamUser(List<TeamUser> teamUser) {
//	 this.teamUser = teamUser;
//	 }

	public CommonParametersEmbaddable getCommonParametersEmbaddable() {
		return commonParametersEmbaddable;
	}

	public void setCommonParametersEmbaddable(CommonParametersEmbaddable commonParametersEmbaddable) {
		this.commonParametersEmbaddable = commonParametersEmbaddable;
	}


}
