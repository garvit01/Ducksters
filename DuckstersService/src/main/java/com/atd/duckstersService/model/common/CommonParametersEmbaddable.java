package com.atd.duckstersService.model.common;

import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class CommonParametersEmbaddable {

	private boolean isActive;
	private Date createdAt;
	private Date lastModified;
	private boolean isVerified;
	
	

	public CommonParametersEmbaddable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public CommonParametersEmbaddable(boolean isActive, Date createdAt, Date lastModified, boolean isVerified) {
		super();
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.lastModified = lastModified;
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



	@Override
	public String toString() {
		return "CommonParametersEmbaddable [isActive=" + isActive + ", createdAt=" + createdAt + ", lastModified="
				+ lastModified + ", isVerified=" + isVerified + "]";
	}
	
	

	

}
