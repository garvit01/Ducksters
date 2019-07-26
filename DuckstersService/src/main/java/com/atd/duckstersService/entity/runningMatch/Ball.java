package com.atd.duckstersService.entity.runningMatch;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.atd.duckstersService.entity.common.CommonParametersEmbaddable;
import com.atd.duckstersService.entity.user.UserProfile;
import com.atd.duckstersService.enums.ExtraRuns;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Ball {

	@Id
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

	@Enumerated(EnumType.STRING)
	private ExtraRuns extrarunType;

	@Column
	int extraRun;

	@ManyToOne
	@JoinColumn(name = "striker_id", nullable = false)
	@JsonBackReference
	private UserProfile striker;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "isActive", column = @Column(name = "isActive")),
			@AttributeOverride(name = "createdAt", column = @Column(name = "createdAt")),
			@AttributeOverride(name = "lastModified", column = @Column(name = "lastModified")),
			@AttributeOverride(name = "isVerified", column = @Column(name = "isVerified")) })
	private CommonParametersEmbaddable commonParametersEmbaddable;

	public Ball() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ball(int id, Over overOfThisBall, int bowlNumber, int runScored, boolean isExtraBall, ExtraRuns extrarunType,
			int extraRun, UserProfile user, CommonParametersEmbaddable commonParametersEmbaddable) {
		super();
		this.id = id;
		this.overOfThisBall = overOfThisBall;
		this.bowlNumber = bowlNumber;
		this.runScored = runScored;
		this.isExtraBall = isExtraBall;
		this.extrarunType = extrarunType;
		this.extraRun = extraRun;
		this.striker = user;
		this.commonParametersEmbaddable = commonParametersEmbaddable;
	}

	public Over getOverOfThisBall() {
		return overOfThisBall;
	}

	public void setOverOfThisBall(Over overOfThisBall) {
		this.overOfThisBall = overOfThisBall;
	}

	public CommonParametersEmbaddable getCommonParametersEmbaddable() {
		return commonParametersEmbaddable;
	}

	public void setCommonParametersEmbaddable(CommonParametersEmbaddable commonParametersEmbaddable) {
		this.commonParametersEmbaddable = commonParametersEmbaddable;
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

	public UserProfile getUser() {
		return striker;
	}

	public void setUser(UserProfile user) {
		this.striker = user;
	}

}
