package com.example.java_demo_practice.entity;

import java.util.HashMap;
import java.util.Map;

public class Menu {
	private Map<String, Integer> map = new HashMap<>();

	public Menu() {
	}

	public Menu(String a, Integer b) {
		map.put(a, b);

	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}
}
