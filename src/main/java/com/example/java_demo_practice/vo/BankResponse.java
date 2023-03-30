package com.example.java_demo_practice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankResponse {

	private String account;
	private Integer amount;
	private Integer money;
	private String message;

	public String getAccount() {
		return account;
	}

	public BankResponse() {

	}

	public BankResponse(String account, Integer amount, String message) {
		super();
		this.account = account;
		this.amount = amount;
		this.message = message;
	}

	public BankResponse(String account, Integer money, Integer amount, String message) {
		super();
		this.account = account;
		this.money = money;
		this.amount = amount;
		this.message = message;
	}

	public BankResponse(String account, String message) {
		super();
		this.account = account;
		this.message = message;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

}
