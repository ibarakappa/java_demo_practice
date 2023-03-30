package com.example.java_demo_practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_demo_practice.service.ifs.BankService;
import com.example.java_demo_practice.vo.BankRequest;
import com.example.java_demo_practice.vo.BankResponse;
import com.example.java_demo_practice.vo.BankUpdateRequest;

@RestController
public class BankController {

	@Autowired
	private BankService bankService;

	@PostMapping("/add_account")
	public BankResponse addAccoount(@RequestBody BankRequest bankRequest) {
		return bankService.addAccoount(bankRequest);
	}

//	�U�赥�P��: @RequestMapping(value = "/get_amount", method = RequestMethod.POST)
	@PostMapping("/get_amount")
	/// �z�Lget_amount�q�D�i�J�U����k
	public BankResponse getAmount(@RequestBody BankRequest bankRequest) {
		// request �O�~�����
		// @RequestBody�i�NbankRequest�j�w��web�ШD���D��
		// �N�Yweb�ШD����ƧY�OBankRequest����k���ݩ�
		// �]��BankRequest�����ݩʦW�٭n�P�~����J���ݩʦW�٤@�P
		// response���^�ǥXcontroller����
		return bankService.getAmount(bankRequest);
		// �I�sservice�����k�ñN��ƥ�^request

	}

	@PostMapping("/get_deposit")
	public BankResponse deposit(@RequestBody BankRequest bankRequest) {
		return bankService.deposit(bankRequest);
	}

	@PostMapping("/get_withdraw")
	public BankResponse withdraw(@RequestBody BankRequest bankRequest) {
		return bankService.withdraw(bankRequest);
	}

	@PostMapping("/get_updatePwd")
	public BankResponse updatePwd(@RequestBody BankUpdateRequest BankUpdateRequest) {
		return bankService.updatePwd(BankUpdateRequest);
	}

}
