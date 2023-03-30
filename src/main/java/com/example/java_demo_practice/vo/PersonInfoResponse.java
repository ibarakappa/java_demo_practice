package com.example.java_demo_practice.vo;

import com.example.java_demo_practice.entity.PersonInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonInfoResponse {
	@JsonProperty("person_info")
	private PersonInfo personInfo;

	String message;

	public PersonInfoResponse() {
		super();
	}

	public PersonInfoResponse(PersonInfo personInfo, String message) {
		super();
		this.personInfo = personInfo;
		this.message = message;
	}

	public PersonInfoResponse(PersonInfo personInfo) {
		super();
		this.personInfo = personInfo;
	}

	public PersonInfoResponse(String message) {
		super();
		this.message = message;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
