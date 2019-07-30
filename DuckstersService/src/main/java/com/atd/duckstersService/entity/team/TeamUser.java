package com.atd.duckstersService.entity.team;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.atd.duckstersService.entity.user.UserProfile;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "teamusermap")
public class TeamUser {

	@Id
	int id;

	@ManyToOne
	@JoinColumn(name = "team_id", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Team teamMap;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private UserProfile userMap;

	public TeamUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeamUser(int id, Team teamMap, UserProfile userMap) {
		super();
		this.id = id;
		this.teamMap = teamMap;
		this.userMap = userMap;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JsonIgnore
	public Team getTeamMap() {
		return teamMap;
	}

	public void setTeamMap(Team teamMap) {
		this.teamMap = teamMap;
	}

	@JsonIgnore
	public UserProfile getUserMap() {
		return userMap;
	}

	public void setUserMap(UserProfile userMap) {
		this.userMap = userMap;
	}

}
