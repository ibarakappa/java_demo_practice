package com.example.java_demo_practice.service.impl;

import org.springframework.stereotype.Service;

import com.example.java_demo_practice.entity.Bank;
import com.example.java_demo_practice.service.ifs.BankService;

@Service
public class BankServiceImpl implements BankService {

	@Override
	public void getAmount(Bank bank) {
		System.out.printf("�Ȧ�b�� %s ���l�B��: %d%n", bank.getAccount(), bank.getAmount());

	}

	@Override
	public void deposit(Bank bank, int depositAmount) {
		getAmount(bank);
		int depositA = bank.getAmount();
		depositA = bank.getAmount() + depositAmount;
		System.out.printf("�s�ڦ��\! �Ȧ�b�� %s ���l�B��: %d%n", bank.getAccount(), depositA);
		bank.setAmount(depositA);
	}

	@Override
	public void withdraw(Bank bank, int withdrawAmount) {
		getAmount(bank);
		if (bank.getAmount() < withdrawAmount) {
			System.out.printf("���ڥ���! �Ȧ�b�� %s ���l�B��: %d%n", bank.getAccount(), bank.getAmount());
			return;
		}
		int withdrawA = bank.getAmount() - withdrawAmount;
		bank.setAmount(withdrawA);
		System.out.printf("���ڦ��\! �Ȧ�b�� %s ���l�B��: %d%n", bank.getAccount(), withdrawA);

	}

}
