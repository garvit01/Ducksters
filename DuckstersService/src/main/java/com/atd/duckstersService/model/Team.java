package com.atd.duckstersService.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Team {

	@Id
	@Column(name="team_id")
	private int id;

	@Column
	private String name;

	@Column
	private String coverPhoto;

	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<TournamentTeam> listTournaments;
	
	@OneToMany(mappedBy = "joinedTeams", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<MatchInningTeam> matchInningTeam;

}
