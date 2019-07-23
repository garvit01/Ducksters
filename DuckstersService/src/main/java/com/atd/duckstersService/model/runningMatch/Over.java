package com.atd.duckstersService.model.runningMatch;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.atd.duckstersService.model.Tournament.TournamentTeam;
import com.atd.duckstersService.model.match.Match;
import com.atd.duckstersService.model.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="overs")
public class Over {

	@Id
	@Column(name = "over_id")
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
	private User bowler;

	public Over() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Over(int id, int overNo, List<Ball> balls, Match matchOfThisOver, User bowler) {
		super();
		this.id = id;
		this.overNo = overNo;
		this.balls = balls;
		this.matchOfThisOver = matchOfThisOver;
		this.bowler = bowler;
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

	public User getBowler() {
		return bowler;
	}

	public void setBowler(User bowler) {
		this.bowler = bowler;
	}

}
