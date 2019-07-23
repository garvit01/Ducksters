package com.atd.duckstersService.model.user;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.atd.duckstersService.enums.RoleType;
import com.atd.duckstersService.model.Tournament.TournamentAwards;
import com.atd.duckstersService.model.common.CommonParametersEmbaddable;
import com.atd.duckstersService.model.match.Match;
import com.atd.duckstersService.model.match.MatchAwards;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "profile")
public class User {

	@Id
	private int id;

	@Column
	private String name;

	@Column
	private String email;

	@Column
	private String password;

	@Column
	private RoleType roleType;

	@Column
	private String state;

	@Column
	private int rating;

	@Column
	private String address;

	@Column
	private String country;

	@Column
	private int pincode;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "isActive", column = @Column(name = "isActive")),
			@AttributeOverride(name = "createdAt", column = @Column(name = "createdAt")),
			@AttributeOverride(name = "lastModified", column = @Column(name = "lastModified")) })
	private CommonParametersEmbaddable commonParametersEmbaddable;

	@OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Match> listMatches;

	@OneToMany(mappedBy = "matchAwardedUser", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<MatchAwards> listMatchAwards;
	
	@OneToMany(mappedBy = "tournamentAwardedUser", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<TournamentAwards> listTournamentAwards;
	
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public CommonParametersEmbaddable getCommonParametersEmbaddable() {
		return commonParametersEmbaddable;
	}

	public void setCommonParametersEmbaddable(CommonParametersEmbaddable commonParametersEmbaddable) {
		this.commonParametersEmbaddable = commonParametersEmbaddable;
	}

	public List<Match> getListMatches() {
		return listMatches;
	}

	public void setListMatches(List<Match> listMatches) {
		this.listMatches = listMatches;
	}

	public List<MatchAwards> getListMatchAwards() {
		return listMatchAwards;
	}

	public void setListMatchAwards(List<MatchAwards> listMatchAwards) {
		this.listMatchAwards = listMatchAwards;
	}

	public List<TournamentAwards> getListTournamentAwards() {
		return listTournamentAwards;
	}

	public void setListTournamentAwards(List<TournamentAwards> listTournamentAwards) {
		this.listTournamentAwards = listTournamentAwards;
	}
	
	

}
