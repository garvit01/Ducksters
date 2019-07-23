package com.atd.duckstersService.model.match;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.atd.duckstersService.enums.Awards;
import com.atd.duckstersService.model.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class MatchAwards {

	@Id
	private int id;

	@ManyToOne
	@JoinColumn(name = "match_id", nullable = true)
	@JsonBackReference
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Match matchForAwards;

	@ManyToOne
	@JoinColumn(name = "award_winner_user_id", nullable = true)
	@JsonBackReference
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User matchAwardedUser;

	@Enumerated(EnumType.STRING)
	private Awards award;

	public MatchAwards() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MatchAwards(int id, Match match, User user, Awards award) {
		super();
		this.id = id;
		this.matchForAwards = match;
		this.matchAwardedUser = user;
		this.award = award;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Match getMatch() {
		return matchForAwards;
	}

	public void setMatch(Match match) {
		this.matchForAwards = match;
	}

	public User getUser() {
		return matchAwardedUser;
	}

	public void setUser(User user) {
		this.matchAwardedUser = user;
	}

	public Awards getAward() {
		return award;
	}

	public void setAward(Awards award) {
		this.award = award;
	}

}
