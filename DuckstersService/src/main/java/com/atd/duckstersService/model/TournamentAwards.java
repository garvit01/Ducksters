package com.atd.duckstersService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TournamentAwards {

	@Id
	@Column(name = "award_id")
	private int id;

	@Column(name = "award_name")
	private String awardName;

	public TournamentAwards() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TournamentAwards(int id, String awardName) {
		super();
		this.id = id;
		this.awardName = awardName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

	@Override
	public String toString() {
		return "TournamentAwards [id=" + id + ", awardName=" + awardName + "]";
	}

}
