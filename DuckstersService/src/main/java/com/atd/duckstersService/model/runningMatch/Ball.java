package com.atd.duckstersService.model.runningMatch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.atd.duckstersService.enums.ExtraRuns;
import com.atd.duckstersService.model.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Ball {

	@Id
	@Column(name = "bowl_id")
	int id;

	@ManyToOne
	@JoinColumn(name = "over_id", nullable = false)
	@JsonBackReference
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Over overOfThisBall;

	@Column
	private int bowlNumber;

	@Column
	private int runScored;

	@Column
	private boolean isExtraBall;

	@Enumerated
	private ExtraRuns extrarunType;

	@Column
	int extraRun;

	@ManyToOne
	@JoinColumn(name = "striker_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;

	public Ball() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ball(int id, Over over, int bowlNumber, int runScored, boolean isExtraBall, ExtraRuns extrarunType,
			int extraRun, User user) {
		super();
		this.id = id;
		this.overOfThisBall = over;
		this.bowlNumber = bowlNumber;
		this.runScored = runScored;
		this.isExtraBall = isExtraBall;
		this.extrarunType = extrarunType;
		this.extraRun = extraRun;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Over getOver() {
		return overOfThisBall;
	}

	public void setOver(Over over) {
		this.overOfThisBall = over;
	}

	public int getBowlNumber() {
		return bowlNumber;
	}

	public void setBowlNumber(int bowlNumber) {
		this.bowlNumber = bowlNumber;
	}

	public int getRunScored() {
		return runScored;
	}

	public void setRunScored(int runScored) {
		this.runScored = runScored;
	}

	public boolean isExtraBall() {
		return isExtraBall;
	}

	public void setExtraBall(boolean isExtraBall) {
		this.isExtraBall = isExtraBall;
	}

	public ExtraRuns getExtrarunType() {
		return extrarunType;
	}

	public void setExtrarunType(ExtraRuns extrarunType) {
		this.extrarunType = extrarunType;
	}

	public int getExtraRun() {
		return extraRun;
	}

	public void setExtraRun(int extraRun) {
		this.extraRun = extraRun;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
