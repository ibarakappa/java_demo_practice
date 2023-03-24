package com.example.java_demo_practice.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.java_demo_practice.entity.Menu;
import com.example.java_demo_practice.service.ifs.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	Menu menu;
	int total = 0;

	@Override
	public void totalPrice(Menu menu, Map<String, Integer> map) {
		int onePrice;
		int amount;
		for (Map.Entry<String, Integer> item : map.entrySet()) {
			onePrice = menu.getMap().get(item.getKey()) * item.getValue();
			System.out.printf("%s»ù®æ¬°%d", item.getKey(), onePrice);
		}
	}
}
