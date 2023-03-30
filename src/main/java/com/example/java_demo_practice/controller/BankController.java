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

//	下方等同於: @RequestMapping(value = "/get_amount", method = RequestMethod.POST)
	@PostMapping("/get_amount")
	/// 透過get_amount通道進入下面方法
	public BankResponse getAmount(@RequestBody BankRequest bankRequest) {
		// request 是外部資料
		// @RequestBody可將bankRequest綁定到web請求的主體
		// 意即web請求的資料即是BankRequest的方法及屬性
		// 因此BankRequest當中的屬性名稱要與外部輸入的屬性名稱一致
		// response為回傳出controller的值
		return bankService.getAmount(bankRequest);
		// 呼叫service執行方法並將資料丟回request

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
