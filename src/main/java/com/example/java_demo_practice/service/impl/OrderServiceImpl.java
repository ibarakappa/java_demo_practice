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
		if (meal.equals("���b")) {
			if (total >= 500) {
				total = (total > 500) ? (int) (total * 0.9) : total;
				System.out.printf("�z���\�I�`�B���E��ᬰ%d��%n", total);
				return;
			} else {
				System.out.printf("�z���\�I�`�B���E��ᬰ%d��%n", total);
				return;
			}
		}
		System.out.println("�п�J�\�I�W�٤μƶq");
		if (!menu.getMap().containsKey(meal)) {
			System.out.println("�п�J�\�I���T�W��");
			return;
		}
		System.out.printf("�z�I�F%s�A�@ %d ��%n", meal, amount);
		price = menu.getMap().get(meal) * amount;
		total += price;
		System.out.printf("%s�����欰 : %d %n", meal, price);
		System.out.printf("�z���\�I�`�B��%d��%n", total);

//		try (Scanner scan = new Scanner(System.in)) {
//			while (true) {
//				meal = scan.nextLine();
//				if (meal.equals("�I�\����")) {
//					break;
//				} else if (!menu.getMap().containsKey(meal)) {
//					System.out.println("�п�J�\�I���T�W��");
//					continue;
//				}
//				amount = scan.nextInt();
//				System.out.printf("�z�I�F%s�A�@ %d ��%n", meal, amount);
//				price = menu.getMap().get(meal) * amount;
//				total += price;
//				System.out.printf("%s�����欰 : %d %n", meal, price);
//			}
//		}
//		total = (total > 500) ? (int) (total * 0.9) : total;

	}
}
