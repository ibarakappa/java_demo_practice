package com.example.java_demo_practice.service.impl;

import org.springframework.stereotype.Service;

import com.example.java_demo_practice.entity.Menu;
import com.example.java_demo_practice.service.ifs.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	Menu menu;
	int total = 0;

//	@Override
//	public Map<String, Integer> addMeal(Menu menu) {
//		menu.getMap();
//		return menu.getMap();
//	}

	@Override
	public void totalPrice(Menu menu, String meal, int amount) {
		int price = 0;
		if (meal.equals("結帳")) {
			if (total >= 500) {
				total = (total > 500) ? (int) (total * 0.9) : total;
				System.out.printf("您的餐點總額打九折後為%d元%n", total);
				return;
			} else {
				System.out.printf("您的餐點總額打九折後為%d元%n", total);
				return;
			}
		}
		System.out.println("請輸入餐點名稱及數量");
		if (!menu.getMap().containsKey(meal)) {
			System.out.println("請輸入餐點正確名稱");
			return;
		}
		System.out.printf("您點了%s，共 %d 份%n", meal, amount);
		price = menu.getMap().get(meal) * amount;
		total += price;
		System.out.printf("%s的價格為 : %d %n", meal, price);
		System.out.printf("您的餐點總額為%d元%n", total);

//		try (Scanner scan = new Scanner(System.in)) {
//			while (true) {
//				meal = scan.nextLine();
//				if (meal.equals("點餐完畢")) {
//					break;
//				} else if (!menu.getMap().containsKey(meal)) {
//					System.out.println("請輸入餐點正確名稱");
//					continue;
//				}
//				amount = scan.nextInt();
//				System.out.printf("您點了%s，共 %d 份%n", meal, amount);
//				price = menu.getMap().get(meal) * amount;
//				total += price;
//				System.out.printf("%s的價格為 : %d %n", meal, price);
//			}
//		}
//		total = (total > 500) ? (int) (total * 0.9) : total;

	}
}
