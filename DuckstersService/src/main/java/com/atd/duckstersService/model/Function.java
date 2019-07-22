package com.atd.duckstersService.model;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="functions")
public class Function {

	@Id
	@Column(name="function_id")
	private int id;

	@Column
	private String name;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "isActive", column = @Column(name = "isActive")),
			@AttributeOverride(name = "createdAt", column = @Column(name = "createdAt")),
			@AttributeOverride(name = "lastModified", column = @Column(name = "lastModified")) })
	private CommonParametersEmbaddable commonParametersEmbaddable;
	
	@OneToMany(mappedBy="function",cascade={CascadeType.ALL})
	Set<RoleFunction> roleFunctions;

	public Function() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Function(int id, String name, CommonParametersEmbaddable commonParametersEmbaddable) {
		super();
		this.id = id;
		this.name = name;
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

	public CommonParametersEmbaddable getCommonParametersEmbaddable() {
		return commonParametersEmbaddable;
	}

	public void setCommonParametersEmbaddable(CommonParametersEmbaddable commonParametersEmbaddable) {
		this.commonParametersEmbaddable = commonParametersEmbaddable;
	}

	@Override
	public String toString() {
		return "Functions [id=" + id + ", name=" + name + ", commonParametersEmbaddable=" + commonParametersEmbaddable
				+ "]";
	}
	
	
}
