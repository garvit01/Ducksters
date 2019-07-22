package com.atd.duckstersService.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class RoleFunctionKey implements Serializable {

	@Column(name = "role_id")
	int roleId;

	@Column(name = "function_id")
	int functionId;

	public RoleFunctionKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleFunctionKey(int roleId, int functionId) {
		super();
		this.roleId = roleId;
		this.functionId = functionId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getFunctionId() {
		return functionId;
	}

	public void setFunctionId(int functionId) {
		this.functionId = functionId;
	}

	@Override
	public String toString() {
		return "RoleFunction [roleId=" + roleId + ", functionId=" + functionId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + functionId;
		result = prime * result + roleId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleFunctionKey other = (RoleFunctionKey) obj;
		if (functionId != other.functionId)
			return false;
		if (roleId != other.roleId)
			return false;
		return true;
	}
	
	

}