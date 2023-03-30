package com.example.java_demo_practice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank")
//Table �᪺name�O��Ʈw�W��
public class Bank {
	@Id // @Id���Primary Key
	@Column(name = "account") // @Column:�Ψӫ��wDB"account"��쪺�Ȩ�@Entity����acoount�ݩ�
	private String account;

	@Column(name = "pwd")
	private String pwd;

	@Column(name = "amount")
	private int amount;

	public Bank() {

	}

	public Bank(String account, String pwd) {
		super();
		this.account = account;
		this.pwd = pwd;
	}

	public Bank(String account, int amount) {
		this.account = account;
		this.amount = amount;
	}

	public Bank(String account, String pwd, int amount) {
		super();
		this.account = account;
		this.pwd = pwd;
		this.amount = amount;
	}

	public Bank(int amount) {
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
