package com.atd.duckstersService.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "roleId")
	Role role;

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(int id, Role role) {
		super();
		this.id = id;
		this.role = role;
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

	@Override
	public String toString() {
		return "Member [id=" + id + ", role=" + role + "]";
	}

}
