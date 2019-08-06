package com.atd.duckstersService.entity.common;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RequestLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serialNo;

	@Column
	private String reqMethod;

	@Column
	private String serverIp;

	@Column
	private String remoteIp;

	@Column
	private String reqUrl;

	@Column(length = 1024)
	private String reqParam;

	@Column
	private Date reqTime;

	@Column(length = 1024)
	private String response;

	public RequestLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestLog(int serialNo, String reqMethod, String serverIp, String remoteIp, String reqUrl, String reqParam,
			Date reqTime, String response) {
		super();
		this.serialNo = serialNo;
		this.reqMethod = reqMethod;
		this.serverIp = serverIp;
		this.remoteIp = remoteIp;
		this.reqUrl = reqUrl;
		this.reqParam = reqParam;
		this.reqTime = reqTime;
		this.response = response;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getReqMethod() {
		return reqMethod;
	}

	public void setReqMethod(String reqMethod) {
		this.reqMethod = reqMethod;
	}

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public String getRemoteIp() {
		return remoteIp;
	}

	public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
	}

	public String getReqUrl() {
		return reqUrl;
	}

	public void setReqUrl(String reqUrl) {
		this.reqUrl = reqUrl;
	}

	public String getReqParam() {
		return reqParam;
	}

	public void setReqParam(String reqParam) {
		this.reqParam = reqParam;
	}

	public Date getReqTime() {
		return reqTime;
	}

	public void setReqTime(Date reqTime) {
		this.reqTime = reqTime;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "RequestLog [serialNo=" + serialNo + ", reqMethod=" + reqMethod + ", serverIp=" + serverIp
				+ ", remoteIp=" + remoteIp + ", reqUrl=" + reqUrl + ", reqParam=" + reqParam + ", reqTime=" + reqTime
				+ ", response=" + response + "]";
	}

}
