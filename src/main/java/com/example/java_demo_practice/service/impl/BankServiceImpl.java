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
	// 此為假造資料庫的其中一筆資料
	// 實際流程是先去資料庫確認資料(帳號&密碼)
	// 確認完後再去DB撈帳號餘額

	@Override
	public BankResponse getAmount(BankRequest bankRequest) {
		if (checkAccount(bankRequest)) {
			return new BankResponse(bankRequest.getAccount(), bank.getAmount(), "成功");
		}
		return new BankResponse(bankRequest.getAccount(), null, "帳號或密碼錯誤");
		// return值出去
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
				// 使用equalsIgnoreCase可無視大小寫
				&& bankRequest.getPwd().equals(bank.getPwd());
		return result;
	}

	private BankResponse depositOrWithdraw(BankRequest bankRequest, boolean isWithdraw) {
		boolean check = checkAccount(bankRequest);
		if (check) {
			if (bankRequest.getMoney() <= 0) {
				return new BankResponse(bankRequest.getAccount(), "金額輸入錯誤! 請輸入大於0之金額");
			}
			if (isWithdraw) {
				if (bank.getAmount() < bankRequest.getMoney()) {
					return new BankResponse(bankRequest.getAccount(), "提款失敗! 剩餘存款不足");
				}
				int withdrawM = bank.getAmount() - bankRequest.getMoney();
				bank.setAmount(withdrawM);
				return new BankResponse(bankRequest.getAccount(), bankRequest.getMoney(),
						bank.getAmount(), "提款成功");
			}
			int depositM = bank.getAmount() + bankRequest.getMoney();
			bank.setAmount(depositM);
			return new BankResponse(bankRequest.getAccount(), bankRequest.getMoney(),
					bank.getAmount(), "存款成功");
		}
		return new BankResponse(bankRequest.getAccount(), "帳號或密碼錯誤");
	}

	@Override
	public BankResponse addAccoount(BankRequest bankRequest) {
		String account = bankRequest.getAccount();
		if (!StringUtils.hasText(account) || !StringUtils.hasText(bankRequest.getPwd())) {
			return new BankResponse(account, "帳號或密碼不得為空");
		}
		if (bankDao.existsById(account)) {
			return new BankResponse(account, "帳號已存在");
		}
		Bank bankAddAcount = new Bank(account, bankRequest.getPwd());
		Bank result = bankDao.save(bankAddAcount);
		// .save是甚麼意思?
		return new BankResponse(result.getAccount(), "新增帳號成功");

	}

	@Override
	public BankResponse updatePwd(BankUpdateRequest bankUpdateRequest) {
		String reqAc = bankUpdateRequest.getAccount();
		String reqOldpwd = bankUpdateRequest.getPwd();
		String reqNewpwd = bankUpdateRequest.getNewPwd();
		if (!StringUtils.hasText(reqAc) || !StringUtils.hasText(reqOldpwd)
				|| !StringUtils.hasText(reqNewpwd)) {
			return new BankResponse(reqAc, "帳號或密碼不得為空");
		}
		Optional<Bank> checkDb = bankDao.findById(reqAc);
		if (!checkDb.isPresent()) {
			// 判斷optional中的Bank物件是否存在(包含判斷Bank是否為null)
			return new BankResponse(reqAc, "帳號不存在");

		}
		Bank bank = checkDb.get();// 將checkDb的內容取出放進bank，前提是Bank物件存在
		if (!reqOldpwd.equals(bank.getPwd())) {
			return new BankResponse(reqAc, "帳號或密碼錯誤");
		}
		bank.setPwd(reqNewpwd);
		// 修改密碼要比對帳號、密碼是否正確
		// 確認輸入正確後確認新密碼是否有輸入
		// 將舊密碼改為新密碼
		// 將新密碼傳回資料庫
		bankDao.save(bank);
		return new BankResponse(reqAc, "新密碼設定完成");
	}
}
