package com.atd.duckstersService.model.match;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.atd.duckstersService.model.runningMatch.Over;
import com.atd.duckstersService.model.team.Team;
import com.atd.duckstersService.model.user.UserProfile;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "matches")
public class Match {

	@Id
	@Column(name = "match_id")
	private int id;

	@OneToMany(mappedBy = "matches", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<MatchTypes> listMatchTypes;

	@Column
	private String place;

	@Column
	private String scorerName;

	@ManyToOne
	@JoinColumn(name = "organizer_id", nullable = false)
	@JsonBackReference
	@OnDelete(action = OnDeleteAction.CASCADE)
	private UserProfile organizer;

	@OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<MatchInningTeam> listMatchInningTeam;

	@ManyToOne
	@JoinColumn(name = "winner_team_id", nullable = true)
	@JsonBackReference
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Team winnerTeam;

	@OneToMany(mappedBy = "matchForAwards", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<MatchAwards> listMatchAwards;

	@OneToMany(mappedBy = "matchOfThisOver", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Over> listOvers;

	public Match() {
		super();
		// TODO Auto-generated constructor stub
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

	public List<MatchTypes> getMatchTypes() {
		return listMatchTypes;
	}

	public void setMatchTypes(List<MatchTypes> matchTypes) {
		this.listMatchTypes = matchTypes;
	}

	public List<MatchInningTeam> getMatchInningTeam() {
		return listMatchInningTeam;
	}

	public void setMatchInningTeam(List<MatchInningTeam> matchInningTeam) {
		this.listMatchInningTeam = matchInningTeam;
	}

	public Team getWinnerTeam() {
		return winnerTeam;
	}

	public void setWinnerTeam(Team winnerTeam) {
		this.winnerTeam = winnerTeam;
	}

	public List<MatchAwards> getMatchAwards() {
		return listMatchAwards;
	}

	public void setMatchAwards(List<MatchAwards> matchAwards) {
		this.listMatchAwards = matchAwards;
	}

	public List<MatchTypes> getListMatchTypes() {
		return listMatchTypes;
	}

	public void setListMatchTypes(List<MatchTypes> listMatchTypes) {
		this.listMatchTypes = listMatchTypes;
	}

	public List<MatchInningTeam> getListMatchInningTeam() {
		return listMatchInningTeam;
	}

	public void setListMatchInningTeam(List<MatchInningTeam> listMatchInningTeam) {
		this.listMatchInningTeam = listMatchInningTeam;
	}

	public List<MatchAwards> getListMatchAwards() {
		return listMatchAwards;
	}

	public void setListMatchAwards(List<MatchAwards> listMatchAwards) {
		this.listMatchAwards = listMatchAwards;
	}

	public List<Over> getListOvers() {
		return listOvers;
	}

	public void setListOvers(List<Over> listOvers) {
		this.listOvers = listOvers;
	}

}
