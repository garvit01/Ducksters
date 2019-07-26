package com.atd.duckstersService.entity.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class CommonParametersEmbaddable {

	private Boolean isActive;
	private Date createdAt;
	private Date lastModified;
	private Boolean isVerified;
	
	

	public CommonParametersEmbaddable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public CommonParametersEmbaddable(boolean isActive, Date createdAt, Date lastModified, boolean isVerified) {
		super();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.isActive = false;
		this.createdAt = createdAt;
		this.lastModified = date;
		this.isVerified = isVerified;
	}



	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}


	

}
