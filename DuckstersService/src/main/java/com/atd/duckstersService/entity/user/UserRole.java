package com.atd.duckstersService.entity.user;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class UserRole {

	@Id
	int id;

	@ManyToOne(cascade = CascadeType.ALL)
	@MapsId("id")
	@JoinColumn(name = "role_id")
	@JsonBackReference
	Role role;

	@ManyToOne(cascade = CascadeType.ALL)
	@MapsId("id")
	@JoinColumn(name = "user_id")
	@JsonBackReference
	UserProfile user;

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRole(int id, Role role, UserProfile user) {
		super();
		this.id = id;
		this.role = role;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
	}

}
