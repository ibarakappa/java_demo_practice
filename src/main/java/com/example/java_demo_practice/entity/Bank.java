package com.example.java_demo_practice.entity;

public class Bank {
	private String account;
	private int amount;

	public Bank() {

	}

	public Bank(String account, int amount) {
		this.account = account;
		this.amount = amount;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
