package com.atd.duckstersService.entity.user;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class RoleFunction {

	@EmbeddedId
	private RoleFunctionKey roleFunctionKey;

	@ManyToOne(cascade=CascadeType.ALL)
	@MapsId("role_id")
	@JoinColumn(name = "role_id")
	@JsonBackReference
	Role role;

	@ManyToOne(cascade=CascadeType.ALL)
	@MapsId("function_id")
	@JoinColumn(name = "function_id")
	@JsonBackReference
	Function function;

	public RoleFunction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleFunction(RoleFunctionKey roleFunctionKey, Role role, Function function) {
		super();
		this.roleFunctionKey = roleFunctionKey;
		this.role = role;
		this.function = function;
	}

	public RoleFunctionKey getRoleFunctionKey() {
		return roleFunctionKey;
	}

	public void setRoleFunctionKey(RoleFunctionKey roleFunctionKey) {
		this.roleFunctionKey = roleFunctionKey;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

//	@Override
//	public String toString() {
//		return "RoleFunction [roleFunctionKey=" + roleFunctionKey + ", role=" + role + ", function=" + function + "]";
//	}
	
	
	

}
