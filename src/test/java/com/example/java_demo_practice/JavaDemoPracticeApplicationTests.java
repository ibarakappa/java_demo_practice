package com.example.java_demo_practice;

import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.java_demo_practice.entity.Bank;
import com.example.java_demo_practice.entity.Bird;
import com.example.java_demo_practice.entity.Menu;
import com.example.java_demo_practice.service.ifs.Active;
import com.example.java_demo_practice.service.ifs.BankService;
import com.example.java_demo_practice.service.ifs.OrderService;

@SpringBootTest
public class JavaDemoPracticeApplicationTests {

	@Autowired
	private Active active;

	@Test
	void contextLoads() {
		Bird bird = new Bird("¤p¤ý", 12);
		active.fly(bird.getName(), bird.getAge());
	}

	@Autowired
	private BankService bankService;

	@Test
	void bankServicetest() {
		Bank bank = new Bank("123-456-6789", 5000);
		bankService.getAmount(bank);
		bankService.deposit(bank, 3000);
		bankService.withdraw(bank, 6000);
		bankService.withdraw(bank, 6000);
	}

	@Autowired
	private OrderService orderService;

	@Test
	void ordertest() {
		Menu menu = new Menu();
		menu.getMap().put("beef", 200);
		menu.getMap().put("chicken", 150);
		menu.getMap().put("pork", 130);

		Scanner scan = new Scanner(System.in);
		while (true) {
			int amount;
			String meal = scan.next();
			if ((amount = 0) == 0 && meal.equals("µ²±b")) {
				orderService.totalPrice(menu, meal, amount);
				break;
			} else {
				amount = scan.nextInt();
			}
			orderService.totalPrice(menu, meal, amount);
		}
	}
}
