package com.example.java_demo_practice.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.java_demo_practice.entity.Bank;
import com.example.java_demo_practice.repository.BankDao;
import com.example.java_demo_practice.service.ifs.BankService;
import com.example.java_demo_practice.vo.BankRequest;
import com.example.java_demo_practice.vo.BankResponse;
import com.example.java_demo_practice.vo.BankUpdateRequest;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private BankDao bankDao;

	Bank bank = new Bank("ABC", "A123", 1000);
	// �������y��Ʈw���䤤�@�����
	// ��ڬy�{�O���h��Ʈw�T�{���(�b��&�K�X)
	// �T�{����A�hDB���b���l�B

	@Override
	public BankResponse getAmount(BankRequest bankRequest) {
		if (checkAccount(bankRequest)) {
			return new BankResponse(bankRequest.getAccount(), bank.getAmount(), "���\");
		}
		return new BankResponse(bankRequest.getAccount(), null, "�b���αK�X���~");
		// return�ȥX�h
	}

	@Override
	public BankResponse deposit(BankRequest bankRequest) {
		return depositOrWithdraw(bankRequest, false);
	}

	@Override
	public BankResponse withdraw(BankRequest bankRequest) {
		return depositOrWithdraw(bankRequest, true);

	}

	private boolean checkAccount(BankRequest bankRequest) {
		boolean result = bankRequest.getAccount().equals(bank.getAccount())
				// �ϥ�equalsIgnoreCase�i�L���j�p�g
				&& bankRequest.getPwd().equals(bank.getPwd());
		return result;
	}

	private BankResponse depositOrWithdraw(BankRequest bankRequest, boolean isWithdraw) {
		boolean check = checkAccount(bankRequest);
		if (check) {
			if (bankRequest.getMoney() <= 0) {
				return new BankResponse(bankRequest.getAccount(), "���B��J���~! �п�J�j��0�����B");
			}
			if (isWithdraw) {
				if (bank.getAmount() < bankRequest.getMoney()) {
					return new BankResponse(bankRequest.getAccount(), "���ڥ���! �Ѿl�s�ڤ���");
				}
				int withdrawM = bank.getAmount() - bankRequest.getMoney();
				bank.setAmount(withdrawM);
				return new BankResponse(bankRequest.getAccount(), bankRequest.getMoney(),
						bank.getAmount(), "���ڦ��\");
			}
			int depositM = bank.getAmount() + bankRequest.getMoney();
			bank.setAmount(depositM);
			return new BankResponse(bankRequest.getAccount(), bankRequest.getMoney(),
					bank.getAmount(), "�s�ڦ��\");
		}
		return new BankResponse(bankRequest.getAccount(), "�b���αK�X���~");
	}

	@Override
	public BankResponse addAccoount(BankRequest bankRequest) {
		String account = bankRequest.getAccount();
		if (!StringUtils.hasText(account) || !StringUtils.hasText(bankRequest.getPwd())) {
			return new BankResponse(account, "�b���αK�X���o����");
		}
		if (bankDao.existsById(account)) {
			return new BankResponse(account, "�b���w�s�b");
		}
		Bank bankAddAcount = new Bank(account, bankRequest.getPwd());
		Bank result = bankDao.save(bankAddAcount);
		// .save�O�ƻ�N��?
		return new BankResponse(result.getAccount(), "�s�W�b�����\");

	}

	@Override
	public BankResponse updatePwd(BankUpdateRequest bankUpdateRequest) {
		String reqAc = bankUpdateRequest.getAccount();
		String reqOldpwd = bankUpdateRequest.getPwd();
		String reqNewpwd = bankUpdateRequest.getNewPwd();
		if (!StringUtils.hasText(reqAc) || !StringUtils.hasText(reqOldpwd)
				|| !StringUtils.hasText(reqNewpwd)) {
			return new BankResponse(reqAc, "�b���αK�X���o����");
		}
		Optional<Bank> checkDb = bankDao.findById(reqAc);
		if (!checkDb.isPresent()) {
			// �P�_optional����Bank����O�_�s�b(�]�t�P�_Bank�O�_��null)
			return new BankResponse(reqAc, "�b�����s�b");

		}
		Bank bank = checkDb.get();// �NcheckDb�����e���X��ibank�A�e���OBank����s�b
		if (!reqOldpwd.equals(bank.getPwd())) {
			return new BankResponse(reqAc, "�b���αK�X���~");
		}
		bank.setPwd(reqNewpwd);
		// �ק�K�X�n���b���B�K�X�O�_���T
		// �T�{��J���T��T�{�s�K�X�O�_����J
		// �N�±K�X�אּ�s�K�X
		// �N�s�K�X�Ǧ^��Ʈw
		bankDao.save(bank);
		return new BankResponse(reqAc, "�s�K�X�]�w����");
	}
}
