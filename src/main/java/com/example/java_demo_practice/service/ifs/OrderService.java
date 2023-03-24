package com.example.java_demo_practice.service.ifs;

import com.example.java_demo_practice.entity.Menu;

public interface OrderService {
//	public Map<String, Integer> addMeal(Menu menu);

	public void totalPrice(Menu menu, String meal, int amount);
}
