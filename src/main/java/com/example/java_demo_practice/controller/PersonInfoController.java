package com.example.java_demo_practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_demo_practice.service.ifs.PersonInfoService;
import com.example.java_demo_practice.vo.PersonInfoRequest;
import com.example.java_demo_practice.vo.PersonInfoRequestA;
import com.example.java_demo_practice.vo.PersonInfoResponse;
import com.example.java_demo_practice.vo.PersonInfoResponseA;

@RestController
public class PersonInfoController {

	@Autowired
	private PersonInfoService personInfoService;

	@PostMapping("/add_PersonInfoA")
	public PersonInfoResponseA addPersonInfo(@RequestBody PersonInfoRequestA personInfoRequest) {
		return personInfoService.addPersonInfo(personInfoRequest);
	}

	@PostMapping("/add_PersonInfo")
	public PersonInfoResponse addPersonInfo(@RequestBody PersonInfoRequest personInfoRequest) {
		return personInfoService.addPersonInfo(personInfoRequest);
	}

	@PostMapping("/get_PersonInfoById")
	public PersonInfoResponse getPersonInfoById(@RequestBody PersonInfoRequest personInfoRequest) {
		return personInfoService.getPersonInfoById(personInfoRequest);
	}
}
