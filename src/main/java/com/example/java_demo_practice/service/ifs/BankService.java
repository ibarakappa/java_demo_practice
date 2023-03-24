package com.example.java_demo_practice.service.ifs;

import com.example.java_demo_practice.entity.Bank;

public interface BankService {
	public void getAmount(Bank bank);

	public void deposit(Bank bank, int depositAmount);

	public void withdraw(Bank bank, int withdrawAmount);
}
