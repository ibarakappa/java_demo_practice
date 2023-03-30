package com.example.java_demo_practice.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BankRequest {
	private String account;
	@JsonProperty("password")
	// 加了@JsonProperty後 只會接收到password 不會接收pwd
	private String pwd;
	@JsonProperty("deposit")
	@JsonAlias("withdraw")
	private int money;

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

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}
