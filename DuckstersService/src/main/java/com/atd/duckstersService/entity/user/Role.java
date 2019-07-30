package com.atd.duckstersService.entity.user;

import java.util.List;
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
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.atd.duckstersService.entity.common.CommonParametersEmbaddable;
import com.atd.duckstersService.entity.team.Team;
import com.atd.duckstersService.enums.RoleType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column
	String name;

	@Enumerated(EnumType.STRING)
	private RoleType roleType;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "isActive", column = @Column(name = "isActive")),
			@AttributeOverride(name = "createdAt", column = @Column(name = "createdAt")),
			@AttributeOverride(name = "lastModified", column = @Column(name = "lastModified")),
			@AttributeOverride(name = "isVerified", column = @Column(name = "isVerified")) })
	private CommonParametersEmbaddable commonParametersEmbaddable;

//	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
//	@JsonManagedReference
//	Set<RoleFunction> roleFunctions;
//
//	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
//	@JsonManagedReference
//	private List<UserRole> listUserRole;


	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int id, String name, RoleType roleType, CommonParametersEmbaddable commonParametersEmbaddable) {
		super();
		this.id = id;
		this.name = name;
		this.roleType = roleType;
		this.commonParametersEmbaddable = commonParametersEmbaddable;
	}

//	public Set<RoleFunction> getRoleFunctions() {
//		return roleFunctions;
//	}
//
//	public void setRoleFunctions(Set<RoleFunction> roleFunctions) {
//		this.roleFunctions = roleFunctions;
//	}
//
//	public List<UserRole> getListUserRole() {
//		return listUserRole;
//	}
//
//	public void setListUserRole(List<UserRole> listUserRole) {
//		this.listUserRole = listUserRole;
//	}

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
	

}
