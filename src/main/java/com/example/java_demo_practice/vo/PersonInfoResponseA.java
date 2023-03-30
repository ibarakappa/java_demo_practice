package com.example.java_demo_practice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonInfoResponseA extends PersonInfoRequest {
	String id;

	String name;

	Integer age;

	String message;

	public PersonInfoResponseA() {
		super();
	}

	public PersonInfoResponseA(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public PersonInfoResponseA(String id, String message) {
		super();
		this.id = id;
		this.message = message;
	}

	public PersonInfoResponseA(String message) {
		super();
		this.message = message;
	}

	public PersonInfoResponseA(String id, String name, int age, String message) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
