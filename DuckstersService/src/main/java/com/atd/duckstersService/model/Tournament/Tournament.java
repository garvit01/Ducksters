package com.atd.duckstersService.model.Tournament;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.atd.duckstersService.model.common.Scheme;
import com.atd.duckstersService.model.team.Team;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Tournament {

	@Id
	@Column(name = "tournament_id")
	private int id;

	@Column
	private String name;

	@Column
	private String description;

	@Column
	private String place;

	@Column
	private boolean status;

	@Column
	private Date startDate;

	@Column
	private Date endDate;

	@Column
	private Date lastRegistrationDate;

	@Column
	private String venue;

	@Column
	private int minTeams;

	@Column
	private int maxTeams;

	@ManyToOne
	@JoinColumn(name = "winner_team_id", nullable = true)
	@JsonBackReference
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Team tournamentWinnerTeam;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "scheme_id")
	private Scheme scheme;

	@OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<TournamentTeam> listtournamentTeams;

	@OneToMany(mappedBy = "tournamentForAwards", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<TournamentAwards> listtournamentAwards;

	public Tournament() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tournament(int id, String name, String description, String place, boolean status, Date startDate,
			Date endDate, Date lastRegistrationDate, String venue, int minTeams, int maxTeams, Team winningTeam) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.place = place;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.lastRegistrationDate = lastRegistrationDate;
		this.venue = venue;
		this.minTeams = minTeams;
		this.maxTeams = maxTeams;
		this.tournamentWinnerTeam = winningTeam;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getLastRegistrationDate() {
		return lastRegistrationDate;
	}

	public void setLastRegistrationDate(Date lastRegistrationDate) {
		this.lastRegistrationDate = lastRegistrationDate;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public int getMinTeams() {
		return minTeams;
	}

	public void setMinTeams(int minTeams) {
		this.minTeams = minTeams;
	}

	public int getMaxTeams() {
		return maxTeams;
	}

	public void setMaxTeams(int maxTeams) {
		this.maxTeams = maxTeams;
	}

	public Team getWinningTeam() {
		return tournamentWinnerTeam;
	}

	public void setWinningTeam(Team winningTeam) {
		this.tournamentWinnerTeam = winningTeam;
	}

	public Team getTournamentWinnerTeam() {
		return tournamentWinnerTeam;
	}

	public void setTournamentWinnerTeam(Team tournamentWinnerTeam) {
		this.tournamentWinnerTeam = tournamentWinnerTeam;
	}

	public Scheme getScheme() {
		return scheme;
	}

	public void setScheme(Scheme scheme) {
		this.scheme = scheme;
	}

	public List<TournamentTeam> getTournamentTeams() {
		return listtournamentTeams;
	}

	public void setTournamentTeams(List<TournamentTeam> tournamentTeams) {
		this.listtournamentTeams = tournamentTeams;
	}

	public List<TournamentAwards> getTournamentAwards() {
		return listtournamentAwards;
	}

	public void setTournamentAwards(List<TournamentAwards> tournamentAwards) {
		this.listtournamentAwards = tournamentAwards;
	}

}
