package com.example.java_demo_practice.service.impl;

import org.springframework.stereotype.Service;

import com.example.java_demo_practice.service.ifs.Active;

@Service
public class ActiveImpl implements Active {

	@Override
	public void fly(String name, int age) {
//		Bird bird = new Bird(name, age);
//		System.out.println("今年" + bird.getAge() + "歲");
//		System.out.println(bird.getName() + "正在飛");
		System.out.println(name + "正在飛");
		System.out.println("今年" + age + "歲");
	}

}
