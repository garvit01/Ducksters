package com.atd.duckstersService.entity.runningMatch;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.atd.duckstersService.entity.common.CommonParametersEmbaddable;
import com.atd.duckstersService.entity.match.Match;
import com.atd.duckstersService.entity.user.UserProfile;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "overs")
public class Over {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;

	@Column
	int overNo;

	@OneToMany(mappedBy = "overOfThisBall", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Ball> balls;

	@ManyToOne
	@JoinColumn(name = "match_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonBackReference
	private Match matchOfThisOver;

	@ManyToOne
	@JoinColumn(name = "bowler_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonBackReference
	private UserProfile bowler;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "isActive", column = @Column(name = "isActive")),
			@AttributeOverride(name = "createdAt", column = @Column(name = "createdAt")),
			@AttributeOverride(name = "lastModified", column = @Column(name = "lastModified")),
			@AttributeOverride(name = "isVerified", column = @Column(name = "isVerified"))})
	private CommonParametersEmbaddable commonParametersEmbaddable;

	public Over() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Over(int id, int overNo, List<Ball> balls, Match matchOfThisOver, UserProfile bowler,
			CommonParametersEmbaddable commonParametersEmbaddable) {
		super();
		this.id = id;
		this.overNo = overNo;
		this.balls = balls;
		this.matchOfThisOver = matchOfThisOver;
		this.bowler = bowler;
		this.commonParametersEmbaddable = commonParametersEmbaddable;
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

	public int getOverNo() {
		return overNo;
	}

	public void setOverNo(int overNo) {
		this.overNo = overNo;
	}

	public List<Ball> getBalls() {
		return balls;
	}

	public void setBalls(List<Ball> balls) {
		this.balls = balls;
	}

	public Match getMatchOfThisOver() {
		return matchOfThisOver;
	}

	public void setMatchOfThisOver(Match matchOfThisOver) {
		this.matchOfThisOver = matchOfThisOver;
	}

	public UserProfile getBowler() {
		return bowler;
	}

	public void setBowler(UserProfile bowler) {
		this.bowler = bowler;
	}

}
