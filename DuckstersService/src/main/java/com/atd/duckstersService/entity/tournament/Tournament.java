package com.atd.duckstersService.entity.tournament;

import java.util.Date;
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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.atd.duckstersService.entity.common.CommonParametersEmbaddable;
import com.atd.duckstersService.entity.common.Scheme;
import com.atd.duckstersService.entity.team.Team;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Tournament {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String name;

	@Column
	private String description;

	@Column
	private String place;

	@Column
	private String status;

	@Column
	private Date startDate;

	@Column
	private Date endDate;

	@Column
	private Date lastRegistrationDate;

	@Column
	private String venue;

	@Column
	private int minTeams;

	@Column
	private int maxTeams;

	@ManyToOne
	@JoinColumn(name = "winner_team_id", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Team tournamentWinnerTeam;

	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "scheme_id", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonBackReference
	private Scheme scheme;

	@OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "listtournamentTeams")
	private List<TournamentTeam> listtournamentTeams;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "isActive", column = @Column(name = "isActive")),
			@AttributeOverride(name = "createdAt", column = @Column(name = "createdAt")),
			@AttributeOverride(name = "lastModified", column = @Column(name = "lastModified")),
			@AttributeOverride(name = "isVerified", column = @Column(name = "isVerified")) })
	private CommonParametersEmbaddable commonParametersEmbaddable;

	public Tournament() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tournament(int id, String name, String description, String place, String status, Date startDate,
			Date endDate, Date lastRegistrationDate, String venue, int minTeams, int maxTeams,
			Team tournamentWinnerTeam, Scheme scheme, List<TournamentTeam> listtournamentTeams,
			CommonParametersEmbaddable commonParametersEmbaddable) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.place = place;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.lastRegistrationDate = lastRegistrationDate;
		this.venue = venue;
		this.minTeams = minTeams;
		this.maxTeams = maxTeams;
		this.tournamentWinnerTeam = tournamentWinnerTeam;
		this.scheme = scheme;
		this.listtournamentTeams = listtournamentTeams;
		this.commonParametersEmbaddable = commonParametersEmbaddable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getLastRegistrationDate() {
		return lastRegistrationDate;
	}

	public void setLastRegistrationDate(Date lastRegistrationDate) {
		this.lastRegistrationDate = lastRegistrationDate;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public int getMinTeams() {
		return minTeams;
	}

	public void setMinTeams(int minTeams) {
		this.minTeams = minTeams;
	}

	public int getMaxTeams() {
		return maxTeams;
	}

	public void setMaxTeams(int maxTeams) {
		this.maxTeams = maxTeams;
	}

	public Team getWinningTeam() {
		return tournamentWinnerTeam;
	}

	public void setWinningTeam(Team winningTeam) {
		this.tournamentWinnerTeam = winningTeam;
	}

	public Scheme getScheme() {
		return scheme;
	}

	public void setScheme(Scheme scheme) {
		this.scheme = scheme;
	}

	public List<TournamentTeam> getTournamentTeams() {
		return listtournamentTeams;
	}

	public void setTournamentTeams(List<TournamentTeam> tournamentTeams) {
		this.listtournamentTeams = tournamentTeams;
	}

	public CommonParametersEmbaddable getCommonParametersEmbaddable() {
		return commonParametersEmbaddable;
	}

	public void setCommonParametersEmbaddable(CommonParametersEmbaddable commonParametersEmbaddable) {
		this.commonParametersEmbaddable = commonParametersEmbaddable;
	}


	public Team getTournamentWinnerTeam() {
		return tournamentWinnerTeam;
	}

	public void setTournamentWinnerTeam(Team tournamentWinnerTeam) {
		this.tournamentWinnerTeam = tournamentWinnerTeam;
	}

}
