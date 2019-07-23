package com.atd.duckstersService.model.user;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.atd.duckstersService.enums.RoleType;
import com.atd.duckstersService.model.common.CommonParametersEmbaddable;
import com.atd.duckstersService.model.team.Team;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	int id;

	@Column
	String name;

	@Enumerated(EnumType.STRING)
	private RoleType roleType;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "isActive", column = @Column(name = "isActive")),
			@AttributeOverride(name = "createdAt", column = @Column(name = "createdAt")),
			@AttributeOverride(name = "lastModified", column = @Column(name = "lastModified")) })
	private CommonParametersEmbaddable commonParametersEmbaddable;

	@OneToMany(mappedBy = "role", cascade = { CascadeType.ALL })
	Set<RoleFunction> roleFunctions;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int id, String name, RoleType roleType, CommonParametersEmbaddable commonParametersEmbaddable// Set<RoleFunction>
																												// roleFunctions
	) {
		super();
		this.id = id;
		this.name = name;
		this.roleType = roleType;
		this.commonParametersEmbaddable = commonParametersEmbaddable;
		// this.roleFunctions = roleFunctions;
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

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public CommonParametersEmbaddable getCommonParametersEmbaddable() {
		return commonParametersEmbaddable;
	}

	public void setCommonParametersEmbaddable(CommonParametersEmbaddable commonParametersEmbaddable) {
		this.commonParametersEmbaddable = commonParametersEmbaddable;
	}

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true)
	@JsonBackReference
	@OnDelete(action = OnDeleteAction.CASCADE)
	private UserProfile userProfile;

	// public Set<RoleFunction> getRoleFunctions() {
	// return roleFunctions;
	// }
	//
	//
	//
	// public void setRoleFunctions(Set<RoleFunction> roleFunctions) {
	// this.roleFunctions = roleFunctions;
	// }

	// @Override
	// public String toString() {
	// return "Role [id=" + id + ", name=" + name + ", roleType=" + roleType +
	// ", commonParametersEmbaddable="
	// + commonParametersEmbaddable + ", roleFunctions=" + roleFunctions + "]";
	// }

}
