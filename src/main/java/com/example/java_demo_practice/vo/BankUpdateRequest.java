package com.example.java_demo_practice.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankUpdateRequest {
	private String account;
	@JsonProperty("password")
	// 加了@JsonProperty後 只會接收到password 不會接收pwd
	private String pwd;
	@JsonProperty("new password")
	private String newPwd;

	public BankUpdateRequest() {
		super();
	}

	public BankUpdateRequest(String account, String pwd, String newPwd) {
		super();
		this.account = account;
		this.pwd = pwd;
		this.newPwd = newPwd;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

}
