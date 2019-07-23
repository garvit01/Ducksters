package com.atd.duckstersService.model.team;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.atd.duckstersService.model.Tournament.Tournament;
import com.atd.duckstersService.model.Tournament.TournamentTeam;
import com.atd.duckstersService.model.match.Match;
import com.atd.duckstersService.model.match.MatchInningTeam;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Team {

	@Id
	@Column(name = "team_id")
	private int id;

	@Column
	private String name;

	@Column
	private String coverPhoto;

	@OneToMany(mappedBy = "joinedTeams", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<TournamentTeam> listTournaments;

	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<MatchInningTeam> matchInningTeam;

	@OneToMany(mappedBy = "winnerTeam", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Match> winningMatches;
	
	@OneToMany(mappedBy = "tournamentWinnerTeam", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Tournament> winningTournament;

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

	public List<TournamentTeam> getListTournaments() {
		return listTournaments;
	}

	public void setListTournaments(List<TournamentTeam> listTournaments) {
		this.listTournaments = listTournaments;
	}

	public List<MatchInningTeam> getMatchInningTeam() {
		return matchInningTeam;
	}

	public void setMatchInningTeam(List<MatchInningTeam> matchInningTeam) {
		this.matchInningTeam = matchInningTeam;
	}

	public List<Match> getWinningMatches() {
		return winningMatches;
	}

	public void setWinningMatches(List<Match> winningMatches) {
		this.winningMatches = winningMatches;
	}

}
