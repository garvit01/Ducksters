package com.atd.duckstersService.entity.match;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.atd.duckstersService.entity.team.Team;
import com.atd.duckstersService.enums.InningType;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class MatchInningTeam {

	@Id
	private int id;

	@ManyToOne
	@JoinColumn(name = "match_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonBackReference
	private Match match;

	@Enumerated(EnumType.STRING)
	private InningType inningType;

	@ManyToOne
	@JoinColumn(name = "team_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonBackReference
	private Team team;
	
	@Column
	private double score;

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
