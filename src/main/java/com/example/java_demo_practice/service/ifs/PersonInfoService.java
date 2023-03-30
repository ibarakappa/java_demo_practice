package com.example.java_demo_practice.service.ifs;

import java.util.List;

import com.example.java_demo_practice.entity.PersonInfo;
import com.example.java_demo_practice.vo.PersonInfoRequest;
import com.example.java_demo_practice.vo.PersonInfoRequestA;
import com.example.java_demo_practice.vo.PersonInfoResponse;
import com.example.java_demo_practice.vo.PersonInfoResponseA;

public interface PersonInfoService {

	public PersonInfoResponse addPersonInfo(PersonInfoRequest personInfoRequest);

	public PersonInfoResponseA addPersonInfo(PersonInfoRequestA personInfoRequest);

	public List<PersonInfo> getPersonInfo();

	public PersonInfoResponse getPersonInfoById(PersonInfoRequest personInfoRequest);

	public List<PersonInfo> getPersonInfoByAgeLargerThan(int age);
}
