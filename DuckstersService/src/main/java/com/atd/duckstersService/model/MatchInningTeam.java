package com.atd.duckstersService.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.atd.duckstersService.enums.InningType;


@Entity
public class MatchInningTeam {

	@id
	private int id;

	@ManyToOne
	@JoinColumn(name = "match_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Match match;

	private InningType inningType;

	@ManyToOne
	@JoinColumn(name = "team_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Team team;

	public MatchInningTeam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MatchInningTeam(int id, Match match, InningType inningType, Team team) {
		super();
		this.id = id;
		this.match = match;
		this.inningType = inningType;
		this.team = team;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public InningType getInningType() {
		return inningType;
	}

	public void setInningType(InningType inningType) {
		this.inningType = inningType;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}
