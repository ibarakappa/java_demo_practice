package com.example.java_demo_practice.service.ifs;

import com.example.java_demo_practice.vo.BankRequest;
import com.example.java_demo_practice.vo.BankResponse;
import com.example.java_demo_practice.vo.BankUpdateRequest;

public interface BankService {

	// «Ø¥ß±b¸¹
	public BankResponse addAccoount(BankRequest bankRequest);

	public BankResponse getAmount(BankRequest bankRequest);

	public BankResponse deposit(BankRequest bankRequest);

	public BankResponse withdraw(BankRequest bankRequest);

	public BankResponse updatePwd(BankUpdateRequest bankUpdateRequest);
}
