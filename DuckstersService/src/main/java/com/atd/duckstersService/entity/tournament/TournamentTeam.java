package com.atd.duckstersService.entity.tournament;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.atd.duckstersService.entity.team.Team;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class TournamentTeam {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "tournament_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)	
	@JsonBackReference(value="listtournamentTeams")
	private Tournament tournament;

	@ManyToOne
	@JoinColumn(name = "team_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Team joinedTeams;

	@Column
	private Date joinedDate;

	@Column
	private boolean paymentSuccessful;

	public TournamentTeam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TournamentTeam(int id, Tournament tournament, Team joinedTeams, Date joinedDate, boolean paymentSuccessful) {
		super();
		this.id = id;
		this.tournament = tournament;
		this.joinedTeams = joinedTeams;
		this.joinedDate = joinedDate;
		this.paymentSuccessful = paymentSuccessful;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public boolean isPaymentSuccessful() {
		return paymentSuccessful;
	}

	public void setPaymentSuccessful(boolean paymentSuccessful) {
		this.paymentSuccessful = paymentSuccessful;
	}

	public Team getJoinedTeams() {
		return joinedTeams;
	}

	public void setJoinedTeams(Team joinedTeams) {
		this.joinedTeams = joinedTeams;
	}

}
