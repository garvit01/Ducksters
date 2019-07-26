package com.atd.duckstersService.entity.match;

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
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MatchAward {

	@Id
	private int id;

	@ManyToOne
	@JoinColumn(name = "match_id", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Match matchForAwards;

	@ManyToOne
	@JoinColumn(name = "award_winner_user_id", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private UserProfile matchAwardedUser;

	@Enumerated(EnumType.STRING)
	private Awards award;

	public MatchAward() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MatchAward(int id, Match matchForAwards, UserProfile matchAwardedUser, Awards award) {
		super();
		this.id = id;
		this.matchForAwards = matchForAwards;
		this.matchAwardedUser = matchAwardedUser;
		this.award = award;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JsonIgnore
	public Match getMatch() {
		return matchForAwards;
	}

	public void setMatch(Match match) {
		this.matchForAwards = match;
	}

	@JsonIgnore
	public UserProfile getUser() {
		return matchAwardedUser;
	}

	public void setUser(UserProfile user) {
		this.matchAwardedUser = user;
	}

	public Awards getAward() {
		return award;
	}

	public void setAward(Awards award) {
		this.award = award;
	}

}
