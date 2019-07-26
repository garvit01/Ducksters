package com.atd.duckstersService.entity.tournament;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.atd.duckstersService.entity.user.UserProfile;
import com.atd.duckstersService.enums.Awards;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class TournamentAward {

	@Id
	private int id;

	@ManyToOne
	@JoinColumn(name = "tournament_id", nullable = true)
	@JsonBackReference
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Tournament tournamentForAwards;

	@ManyToOne
	@JoinColumn(name = "award_winner_id", nullable = true)
	@JsonBackReference
	@OnDelete(action = OnDeleteAction.CASCADE)
	private UserProfile tournamentAwardedUser;

	@Enumerated(EnumType.STRING)
	private Awards award;

	public TournamentAward(int id, Tournament tournamentForAwards, UserProfile tournamentAwardedUser, Awards award) {
		super();
		this.id = id;
		this.tournamentForAwards = tournamentForAwards;
		this.tournamentAwardedUser = tournamentAwardedUser;
		this.award = award;
	}

	public TournamentAward() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tournament getTournamentForAwards() {
		return tournamentForAwards;
	}

	public void setTournamentForAwards(Tournament tournamentForAwards) {
		this.tournamentForAwards = tournamentForAwards;
	}

	public UserProfile getTournamentAwardedUser() {
		return tournamentAwardedUser;
	}

	public void setTournamentAwardedUser(UserProfile tournamentAwardedUser) {
		this.tournamentAwardedUser = tournamentAwardedUser;
	}

	public Awards getAward() {
		return award;
	}

	public void setAward(Awards award) {
		this.award = award;
	}

}
