package com.example.java_demo_practice.service.impl;

import org.springframework.stereotype.Service;

import com.example.java_demo_practice.service.ifs.Active;

@Service
public class ActiveImpl implements Active {

	@Override
	public void fly(String name, int age) {
//		Bird bird = new Bird(name, age);
//		System.out.println("���~" + bird.getAge() + "��");
//		System.out.println(bird.getName() + "���b��");
		System.out.println(name + "���b��");
		System.out.println("���~" + age + "��");
	}

}
