package com.atd.duckstersService.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Match {

	@Id
	@Column(name = "match_id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "match_type_id", nullable = false)
	@JsonBackReference
	@OnDelete(action = OnDeleteAction.CASCADE)
	private MatchTypes matchTypes;

	@Column
	private String place;

	@Column
	private String scorerName;

	@ManyToOne
	@JoinColumn(name = "match_type_id", nullable = false)
	@JsonBackReference
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User organizer;
	
	@OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<MatchInningTeam> matchInningTeam;


	public Match() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Match(int id, MatchTypes matchTypes, String place, String scorerName, User organizer) {
		super();
		this.id = id;
		this.matchTypes = matchTypes;
		this.place = place;
		this.scorerName = scorerName;
		this.organizer = organizer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MatchTypes getMatchTypes() {
		return matchTypes;
	}

	public void setMatchTypes(MatchTypes matchTypes) {
		this.matchTypes = matchTypes;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getScorerName() {
		return scorerName;
	}

	public void setScorerName(String scorerName) {
		this.scorerName = scorerName;
	}

	public User getOrganizer() {
		return organizer;
	}

	public void setOrganizer(User organizer) {
		this.organizer = organizer;
	}

	
}
