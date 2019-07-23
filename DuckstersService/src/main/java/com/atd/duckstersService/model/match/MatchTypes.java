package com.atd.duckstersService.model.match;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class MatchTypes {

	@Id
	@Column(name="match_type_id")
	private int id;

	@Column(name = "match_type")
	private String type;

	@Column
	private int totalOvers;

	


	@ManyToOne
	@JoinColumn(name = "match_id", nullable = false)
	@JsonBackReference
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Match matches;

	public MatchTypes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MatchTypes(int id, String type, int totalOvers) {
		super();
		this.id = id;
		this.type = type;
		this.totalOvers = totalOvers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTotalOvers() {
		return totalOvers;
	}

	public void setTotalOvers(int totalOvers) {
		this.totalOvers = totalOvers;
	}

	@Override
	public String toString() {
		return "MatchTypes [id=" + id + ", type=" + type + ", totalOvers=" + totalOvers + "]";
	}

}
