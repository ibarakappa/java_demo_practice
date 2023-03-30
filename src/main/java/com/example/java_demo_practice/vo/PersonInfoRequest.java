package com.example.java_demo_practice.vo;

import com.example.java_demo_practice.entity.PersonInfo;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonInfoRequest {

	@JsonProperty("person_info")
	private PersonInfo personInfo;

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

}
